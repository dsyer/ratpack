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

package ratpack.func;

/**
 * A generic type for an object that does some work with a thing.
 *
 * @param <T> The type of thing.
 */
@FunctionalInterface
public interface Action<T> {

  /**
   * Executes the action against the given thing.
   *
   * @param t the thing to execute the action against
   * @throws Exception if anything goes wrong
   */
  void execute(T t) throws Exception;

}
