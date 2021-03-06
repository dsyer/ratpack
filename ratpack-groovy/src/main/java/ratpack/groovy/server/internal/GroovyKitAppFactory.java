/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.groovy.server.internal;

import ratpack.groovy.markup.MarkupRenderer;
import ratpack.groovy.markup.internal.DefaultMarkupRenderer;
import ratpack.groovy.templating.TemplatingModule;
import ratpack.guice.BindingsSpec;
import ratpack.guice.internal.DefaultGuiceBackedHandlerFactory;
import ratpack.launch.LaunchConfig;

public class GroovyKitAppFactory extends DefaultGuiceBackedHandlerFactory {

  public GroovyKitAppFactory(LaunchConfig launchConfig) {
    super(launchConfig);
  }

  @Override
  protected void registerDefaultModules(BindingsSpec bindingsSpec) {
    bindingsSpec.add(new TemplatingModule());
    bindingsSpec.bind(MarkupRenderer.class, DefaultMarkupRenderer.class);
    super.registerDefaultModules(bindingsSpec);
  }

}
