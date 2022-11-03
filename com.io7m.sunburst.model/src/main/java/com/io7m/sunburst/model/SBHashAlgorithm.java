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

package com.io7m.sunburst.model;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

/**
 * The set of supported hash algorithms.
 */

public enum SBHashAlgorithm
{
  /**
   * 256-bit SHA-2.
   */

  SHA2_256 {
    @Override
    public int index()
    {
      return 0;
    }

    @Override
    public String jssAlgorithmName()
    {
      return "SHA-256";
    }
  };

  private static final Map<Integer, SBHashAlgorithm> VALUES =
    Stream.of(values())
      .collect(Collectors.toMap(
        v -> Integer.valueOf(v.index()),
        identity()
      ));

  /**
   * @param index The hash algorithm index
   *
   * @return The hash algorithm associated with the given index
   */

  public static SBHashAlgorithm ofIdentifier(
    final int index)
  {
    return Optional.ofNullable(VALUES.get(index))
      .orElseThrow(() -> {
        throw new IllegalArgumentException(
          "Unrecognized hash algorithm value: %d".formatted(index));
      });
  }

  /**
   * @return The hash algorithm index
   */

  public abstract int index();

  /**
   * @return The name of the algorithm as it appears in the Java Security API
   */

  public abstract String jssAlgorithmName();
}
