package org.andromda.core.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Used for writing resources for the framework. Also keeps histories of
 * previous resources generated so that we can avoid regenerating if the
 * generated resources are current.
 *
 * @author Chad Brandon
 * @author Bob Fields
 */
public class ResourceWriter
{
    /**
     * The shared instance
     */
    private static final ResourceWriter instance = new ResourceWriter();

    /**
     * Gets the shared ResourceWriter instance. Normally you'll want to retrieve
     * the instance through this method.
     *
     * @return the shared instance.
     */
    public static ResourceWriter instance()
    {
        return instance;
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param string the string to write to the file
     * @param file the file to which to write.
     * @param namespace the current namespace for which this resource is being
     *        written.
     * @throws IOException
     */
    public void writeStringToFile(
        final String string,
        final File file,
        final String namespace)
        throws IOException
    {
        ExceptionUtils.checkNull(
            "file",
            file);
        this.writeStringToFile(
            string,
            file.toString(),
            namespace,
            true);
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param string the string to write to the file
     * @param fileLocation the location of the file which to write.
     * @throws IOException
     */
    public void writeStringToFile(
        final String string,
        final String fileLocation)
        throws IOException
    {
        this.writeStringToFile(
            string,
            fileLocation,
            true);
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param string the string to write to the file
     * @param file the file which to write.
     * @throws IOException
     */
    public void writeStringToFile(
        final String string,
        final File file)
        throws IOException
    {
        this.writeStringToFile(
            string,
            file != null ? file.toString() : null,
            true);
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param string the string to write to the file
     * @param fileLocation the location of the file which to write.
     * @param recordHistory whether or not the history of the file should be
     *        recorded.
     */
    private void writeStringToFile(
        final String string,
        final String fileLocation,
        final boolean recordHistory)
        throws IOException
    {
        this.writeStringToFile(
            string,
            fileLocation,
            null,
            recordHistory);
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param string the string to write to the file
     * @param fileLocation the location of the file which to write.
     * @param namespace the current namespace for which this resource is being
     *        written.
     * @throws IOException
     */
    public void writeStringToFile(
        final String string,
        final String fileLocation,
        final String namespace)
        throws IOException
    {
        this.writeStringToFile(
            string,
            fileLocation,
            namespace,
            true);
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param string the string to write to the file
     * @param fileLocation the location of the file which to write.
     * @param namespace the current namespace for which this resource is being
     *        written.
     * @param recordHistory whether or not the history of this file should be
     *        recorded.
     * @throws IOException
     */
    private void writeStringToFile(
        String string,
        final String fileLocation,
        final String namespace,
        final boolean recordHistory)
        throws IOException
    {
        if (string == null)
        {
            string = "";
        }
        ExceptionUtils.checkEmpty(
            "fileLocation",
            fileLocation);

        ResourceUtils.makeDirectories(fileLocation);
        final Merger merger = Merger.instance();
        if (merger.requiresMerge(namespace))
        {
            string = Merger.instance().getMergedString(
                    string,
                    namespace);
        }

        final File file = new File(fileLocation);
        FileUtils.writeStringToFile(file, string, this.encoding);

        if (recordHistory)
        {
            this.recordHistory(file);
        }
    }

    /**
     * Writes the URL contents to a file specified by the fileLocation argument.
     *
     * @param url the URL to read
     * @param fileLocation the location which to write.
     * @throws IOException
     */
    public void writeUrlToFile(
        final URL url,
        final String fileLocation)
        throws IOException
    {
        ResourceUtils.writeUrlToFile(url, fileLocation);
        this.recordHistory(new File(fileLocation));
    }

    /**
     * Stores the encoding to be used for output.
     */
    private String encoding = null;

    /**
     * Sets the encoding to which all output written from this class will be
     * written.
     *
     * @param encoding the encoding type (UTF-8, ISO-8859-1, etc).
     */
    public void setEncoding(String encoding)
    {
        this.encoding = StringUtils.trimToNull(encoding);
    }

    private StringBuffer history = new StringBuffer();

    /**
     * Resets the a history file, to write the history {@link #writeHistory()} must be called.
     *
     * @param modelUri used to construct the file name from the modelUri where the history is stored
     */
    public void resetHistory(final String modelUri)
    {
        String modelFile = modelUri.replace(
                '\\',
                '/');
        int lastSlash = modelFile.lastIndexOf('/');
        if (lastSlash != -1)
        {
            modelFile = modelFile.substring(
                    lastSlash + 1,
                    modelFile.length());
        }
        this.modelFile = modelFile;
        this.history = new StringBuffer();
        this.writtenCount = 0;
    }

    private String modelFile = null;

    /**
     * Stores the count of the resources written over this instance's history.
     */
    private long writtenCount = 0;

    /**
     * Gets the number of currently written resources over the course of this instance's history.
     *
     * @return the number of written resources.
     */
    public long getWrittenCount()
    {
        return this.writtenCount;
    }

    /**
     * The location to which history is written.
     */
    //private static final String HISTORY_LOCATION = Constants.TEMPORARY_DIRECTORY + "history/";
    private String historyDir = null;

    /**
     * Gets the file history storage location.
     * @return model generation history storage location
     */
    public String getHistoryStorage()
    {
        return this.historyDir + '/' + this.modelFile;
    }

    /**
     * Sets the file history storage location.
     * @param historyDirIn the history file storage location
     */
    public void setHistoryStorage(String historyDirIn)
    {
        this.historyDir = historyDirIn;
    }

    /**
     * Writes the output history to disk.
     *
     * @throws IOException
     */
    public void writeHistory()
        throws IOException
    {
        writeStringToFile(
            history.toString(),
            getHistoryStorage(),
            false);
    }

    /**
     * Writes the string to the file specified by the fileLocation argument.
     *
     * @param file the file to which to record the history to
     */
    private void recordHistory(File file)
    {
        // Resource files may be merged multiple times to the temp directory, before the final output file is written
        if (this.history != null && !file.getName().endsWith(".vsl"))
        {
            this.history.append(file).append(',');
        }
        this.writtenCount++;
    }

    /**
     * Checks to see if the history is before the given <code>time</code>.
     *
     * @param time the time in milliseconds to check against.
     * @return true/false
     */
    public boolean isHistoryBefore(long time)
    {
        boolean before = true;
        try
        {
            final File historyFile = new File(getHistoryStorage());
            if (historyFile.exists() && historyFile.lastModified() >= time)
            {
                final String history = ResourceUtils.getContents(new File(getHistoryStorage()).toURI().toURL());
                final String[] fileNames = history.split(",");
                long lastModified = 0;
                for (String fileName : fileNames)
                {
                    if (StringUtils.isNotBlank(fileName))
                    {
                        File file = new File(fileName.trim());

                        // if we find one file that doesn't exist then
                        // before is automatically false
                        if (!file.exists())
                        {
                            lastModified = 0;
                            break;
                        }
                        if (file.lastModified() > lastModified)
                        {
                            lastModified = file.lastModified();
                        }
                    }
                }
                before = time > lastModified;
            }
        }
        catch (IOException ex)
        {
            before = true;
        }
        return before;
    }
}