/*
 * Copyright 2014 Rob Fletcher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.freeside.jdbi.time;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.MonthDay;
import org.skife.jdbi.v2.util.TypedMapper;

/**
 * A +ResultSetMapper+ for retrieving +MonthDay+ values from a SQL query.
 *
 * @see java.time.MonthDay
 */
public class MonthDayMapper extends TypedMapper<MonthDay> {

  /**
   * An instance which extracts value from the first field.
   */
  public static final MonthDayMapper FIRST = new MonthDayMapper(1);

  /**
   * Create a new instance which extracts the value from the first column.
   */
  public MonthDayMapper() {
  }

  /**
   * Create a new instance which extracts the value positionally
   * in the +ResultSet+.
   *
   * @param index 1 based column index into the +ResultSet+.
   */
  public MonthDayMapper(int index) {
    super(index);
  }

  /**
   * Create a new instance which extracts the value by name or alias from the
   * +ResultSet+.
   *
   * @param name The name or alias for the field.
   */
  public MonthDayMapper(String name) {
    super(name);
  }

  @Override
  protected MonthDay extractByName(ResultSet r, String name) throws SQLException {
    return MonthDay.parse(r.getString(name));
  }

  @Override
  protected MonthDay extractByIndex(ResultSet r, int index) throws SQLException {
    return MonthDay.parse(r.getString(index));
  }
}
