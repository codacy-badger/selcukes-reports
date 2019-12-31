package io.github.selcukes.reports.video;

import io.github.selcukes.core.exception.RecorderException;
import org.monte.media.Format;

import java.awt.*;
import java.io.File;
import java.io.IOException;

class MonteScreenRecorderBuilder {

    private GraphicsConfiguration cfg;
    private Format fileFormat;
    private Format screenFormat;
    private Format mouseFormat;
    private Format audioFormat;
    private File folder;
    private Rectangle rectangle;
    private String fileName;

    public static Builder builder() {
        return new MonteScreenRecorderBuilder().new Builder();
    }

    public class Builder {

        public Builder setGraphicConfig(GraphicsConfiguration cfg) {
            MonteScreenRecorderBuilder.this.cfg = cfg;
            return this;
        }

        public Builder setFileFormat(Format fileFormat) {
            MonteScreenRecorderBuilder.this.fileFormat = fileFormat;
            return this;
        }

        public Builder setScreenFormat(Format screenFormat) {
            MonteScreenRecorderBuilder.this.screenFormat = screenFormat;
            return this;
        }

        public Builder setMouseFormat(Format mouseFormat) {
            MonteScreenRecorderBuilder.this.mouseFormat = mouseFormat;
            return this;
        }

        public Builder setAudioFormat(Format audioFormat) {
            MonteScreenRecorderBuilder.this.audioFormat = audioFormat;
            return this;
        }

        public Builder setFolder(File folder) {
            MonteScreenRecorderBuilder.this.folder = folder;
            return this;
        }

        public Builder setFileName(String fileName) {
            MonteScreenRecorderBuilder.this.fileName = fileName;
            return this;
        }

        public Builder setRectangle(Rectangle rectangle) {
            MonteScreenRecorderBuilder.this.rectangle = rectangle;
            return this;
        }

        public MonteScreenRecorder build() {
            try {
                return new MonteScreenRecorder(cfg,
                        rectangle,
                        fileFormat,
                        screenFormat,
                        mouseFormat,
                        audioFormat,
                        folder);
            } catch (IOException | AWTException e) {
                throw new RecorderException(e);
            }
        }

    }
}
