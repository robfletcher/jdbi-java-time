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

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Duration;
import javax.annotation.Nullable;
import org.skife.jdbi.v2.StatementContext;

/**
 * Argument that represents a {@link Duration} value as a +BIGINT+.
 *
 * @see Types#BIGINT
 */
public class DurationArgument extends NullSafeArgument<Duration> {

  public DurationArgument(@Nullable Duration value) {
    super(value, Types.BIGINT);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void applyNotNull(int position, PreparedStatement statement, StatementContext ctx) throws SQLException {
    statement.setLong(position, value.toMillis());
  }
}
