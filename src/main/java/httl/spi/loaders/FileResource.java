/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package httl.spi.loaders;

import httl.Engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 * FileResource. (SPI, Prototype, ThreadSafe)
 * 
 * @see httl.spi.loaders.FileLoader#load(String, String)
 * 
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public class FileResource extends AbstractResource {
    
    private static final long serialVersionUID = 1L;
    
    private final File file;
    
    public FileResource(Engine engine, String name, String encoding, String path) {
        super(engine, name, encoding);
        this.file = new File(path);
    }

    public long getLastModified() {
        return file.lastModified();
    }

    public long getLength() {
        return file.length();
    }

    public Reader getSource() throws IOException {
        return new InputStreamReader(new FileInputStream(this.file), super.getEncoding());
    }
    
}