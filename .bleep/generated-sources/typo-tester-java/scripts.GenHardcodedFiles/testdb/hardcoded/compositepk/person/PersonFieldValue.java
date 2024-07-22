/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.compositepk.person;

import java.util.Optional;

public sealed interface PersonFieldValue<T> {
  public record name(Optional<String> value) implements PersonFieldValue<Optional<String>> {
    public String name() {
      return "name";
    };
  };
  public record one(Long value) implements PersonFieldValue<Long> {
    public String name() {
      return "one";
    };
  };
  public record two(Optional<String> value) implements PersonFieldValue<Optional<String>> {
    public String name() {
      return "two";
    };
  };
  public String name();
  public T value();
}