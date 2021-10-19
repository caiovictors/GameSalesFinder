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
}