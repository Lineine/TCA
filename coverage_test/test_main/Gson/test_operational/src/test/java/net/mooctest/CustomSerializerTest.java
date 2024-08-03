/*
 * Copyright (C) 2009 Google Inc.
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

package net.mooctest.functional;

import static com.google.common.truth.Truth.assertThat;

import net.mooctest.Gson;
import net.mooctest.GsonBuilder;
import net.mooctest.JsonArray;
import net.mooctest.JsonElement;
import net.mooctest.JsonObject;
import net.mooctest.JsonSerializationContext;
import net.mooctest.JsonSerializer;
import net.mooctest.common.TestTypes.Base;
import net.mooctest.common.TestTypes.BaseSerializer;
import net.mooctest.common.TestTypes.ClassWithBaseArrayField;
import net.mooctest.common.TestTypes.ClassWithBaseField;
import net.mooctest.common.TestTypes.Sub;
import net.mooctest.common.TestTypes.SubSerializer;
import java.lang.reflect.Type;
import org.junit.Test;

/**
 * Functional Test exercising custom serialization only. When test applies to both serialization and
 * deserialization then add it to CustomTypeAdapterTest.
 *
 * @author Inderjeet Singh
 */
public class CustomSerializerTest {

  @Test
  public void testBaseClassSerializerInvokedForBaseClassFields() {
    Gson gson =
        new GsonBuilder()
            .registerTypeAdapter(Base.class, new BaseSerializer())
            .registerTypeAdapter(Sub.class, new SubSerializer())
            .create();
    ClassWithBaseField target = new ClassWithBaseField(new Base());
    JsonObject json = (JsonObject) gson.toJsonTree(target);
    JsonObject base = json.get("base").getAsJsonObject();
    assertThat(base.get(Base.SERIALIZER_KEY).getAsString()).isEqualTo(BaseSerializer.NAME);
  }

  @Test
  public void testSubClassSerializerInvokedForBaseClassFieldsHoldingSubClassInstances() {
    Gson gson =
        new GsonBuilder()
            .registerTypeAdapter(Base.class, new BaseSerializer())
            .registerTypeAdapter(Sub.class, new SubSerializer())
            .create();
    ClassWithBaseField target = new ClassWithBaseField(new Sub());
    JsonObject json = (JsonObject) gson.toJsonTree(target);
    JsonObject base = json.get("base").getAsJsonObject();
    assertThat(base.get(Base.SERIALIZER_KEY).getAsString()).isEqualTo(SubSerializer.NAME);
  }

  @Test
  public void testSubClassSerializerInvokedForBaseClassFieldsHoldingArrayOfSubClassInstances() {
    Gson gson =
        new GsonBuilder()
            .registerTypeAdapter(Base.class, new BaseSerializer())
            .registerTypeAdapter(Sub.class, new SubSerializer())
            .create();
    ClassWithBaseArrayField target = new ClassWithBaseArrayField(new Base[] {new Sub(), new Sub()});
    JsonObject json = (JsonObject) gson.toJsonTree(target);
    JsonArray array = json.get("base").getAsJsonArray();
    for (JsonElement element : array) {
      JsonElement serializerKey = element.getAsJsonObject().get(Base.SERIALIZER_KEY);
      assertThat(serializerKey.getAsString()).isEqualTo(SubSerializer.NAME);
    }
  }

  @Test
  public void testBaseClassSerializerInvokedForBaseClassFieldsHoldingSubClassInstances() {
    Gson gson = new GsonBuilder().registerTypeAdapter(Base.class, new BaseSerializer()).create();
    ClassWithBaseField target = new ClassWithBaseField(new Sub());
    JsonObject json = (JsonObject) gson.toJsonTree(target);
    JsonObject base = json.get("base").getAsJsonObject();
    assertThat(base.get(Base.SERIALIZER_KEY).getAsString()).isEqualTo(BaseSerializer.NAME);
  }

  @Test
  public void testSerializerReturnsNull() {
    Gson gson =
        new GsonBuilder()
            .registerTypeAdapter(
                Base.class,
                new JsonSerializer<Base>() {
                  @Override
                  public JsonElement serialize(
                      Base src, Type typeOfSrc, JsonSerializationContext context) {
                    return null;
                  }
                })
            .create();
    JsonElement json = gson.toJsonTree(new Base());
    assertThat(json.isJsonNull()).isTrue();
  }
}
