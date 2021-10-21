package com.inatel.gamesalesfinder.errors;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Exceptions {
  protected String title;
  protected int status;
  protected String details;
  protected String developerMessage;
  protected Date timestamp;

  public Exceptions(String title, int status, String details, String developerMessage) {
    this.title = title;
    this.status = status;
    this.details = details;
    this.developerMessage = developerMessage;
    this.timestamp = new Date();
  }
}