package com.epam.inner.training.model.material;

public class TapeMaterial implements IMaterial{
  @Override
  public boolean isPainted() {
    return false;
  }
  @Override
  public String toString() {
    return "Tape material";
  }
}
