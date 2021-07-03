package com.example.patterns.statergyPattern.behaviours.walkBehaviour;

public class NoWalk implements WalkBehaviour {
  @Override
  public String walk() {
    return "Can't walk";
  }
}
