/*
 * Copyright (C) 2020 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.mooctest.internal.sql;

import net.mooctest.Gson;
import net.mooctest.TypeAdapter;
import net.mooctest.TypeAdapterFactory;
import net.mooctest.reflect.TypeToken;
import net.mooctest.stream.JsonReader;
import net.mooctest.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@SuppressWarnings("JavaUtilDate")
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
  static final TypeAdapterFactory FACTORY =
      new TypeAdapterFactory() {
        @SuppressWarnings("unchecked") // we use a runtime check to make sure the 'T's equal
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
          if (typeToken.getRawType() == Timestamp.class) {
            final TypeAdapter<Date> dateTypeAdapter = gson.getAdapter(Date.class);
            return (TypeAdapter<T>) new SqlTimestampTypeAdapter(dateTypeAdapter);
          } else {
            return null;
          }
        }
      };

  private final TypeAdapter<Date> dateTypeAdapter;

  private SqlTimestampTypeAdapter(TypeAdapter<Date> dateTypeAdapter) {
    this.dateTypeAdapter = dateTypeAdapter;
  }

  @Override
  public Timestamp read(JsonReader in) throws IOException {
    Date date = dateTypeAdapter.read(in);
    return date != null ? new Timestamp(date.getTime()) : null;
  }

  @Override
  public void write(JsonWriter out, Timestamp value) throws IOException {
    dateTypeAdapter.write(out, value);
  }
}
