/*
 * Copyright © 2022 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

/**
 * Asset package system (Inventory)
 */

module com.io7m.sunburst.inventory
{
  uses com.io7m.mime2045.parser.api.MimeParserFactoryType;
  requires static org.osgi.annotation.bundle;
  requires static org.osgi.annotation.versioning;

  requires com.io7m.anethum.api;
  requires com.io7m.jdeferthrow.core;
  requires com.io7m.jmulticlose.core;
  requires com.io7m.jxtrand.vanilla;
  requires com.io7m.mime2045.parser.api;
  requires com.io7m.trasco.api;
  requires com.io7m.trasco.vanilla;
  requires org.jooq;
  requires org.slf4j;
  requires org.xerial.sqlitejdbc;

  requires transitive com.io7m.sunburst.inventory.api;

  opens com.io7m.sunburst.inventory
    to com.io7m.jxtrand.vanilla;

  exports com.io7m.sunburst.inventory.internal.tables.records to org.jooq;
  exports com.io7m.sunburst.inventory.internal.tables to org.jooq;
  exports com.io7m.sunburst.inventory.internal to org.jooq;

  exports com.io7m.sunburst.inventory;
}
