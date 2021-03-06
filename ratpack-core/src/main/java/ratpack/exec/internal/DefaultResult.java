/*
 * Copyright 2014 the original author or authors.
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

package ratpack.exec.internal;

import ratpack.exec.Result;
import ratpack.util.ExceptionUtils;

public class DefaultResult<T> implements Result<T> {

  private final Throwable failure;
  private final T value;

  public static <T> Result<T> success(T value) {
    return new DefaultResult<>(value);
  }

  public static <T> Result<T> failure(Throwable failure) {
    return new DefaultResult<>(failure);
  }

  private DefaultResult(Throwable failure) {
    this.failure = failure;
    this.value = null;
  }

  private DefaultResult(T value) {
    this.value = value;
    this.failure = null;
  }

  @Override
  public Throwable getFailure() {
    return failure;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public boolean isSuccess() {
    return failure == null;
  }

  @Override
  public boolean isFailure() {
    return failure != null;
  }

  @Override
  public T getValueOrThrow() throws Exception {
    if (isFailure()) {
      throw ExceptionUtils.toException(failure);
    } else {
      return value;
    }
  }

}
