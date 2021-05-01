package com.tszala.fp;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class HelloWorld {

  static class Holder {

    private Integer id;

    public Holder(Integer id) {
      this.id = id;
    }

    public Integer getId() {
      return id;
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world");
    Random random = new Random();
    IntStream ints = random.ints(100, 0, 1000);

    //ints.forEach(System.out::println);

    ints.mapToObj(Holder::new)
        .sorted(Comparator.comparing(Holder::getId).reversed())
        .forEach(holder -> System.out.println(String.format("Holder: %s", holder.getId())));
  }

  private static LocalDateTime convertDateToLocalDateTime(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

}
