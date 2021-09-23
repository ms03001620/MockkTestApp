package com.example.mockktestapp;

import android.app.Application;

/**
 * Created by mark on 2021/9/22
 */

class PartBuilder {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        Application application;

        public Builder setApplication(Application application){
            this.application = application;
            return this;
        }

        public BuildResult build(){
            return new BuildResult();
        }
    }
}
