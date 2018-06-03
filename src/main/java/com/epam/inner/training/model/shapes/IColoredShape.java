package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.color.Color;

public interface IColoredShape extends IMaterializedSahpe {

  void paint(Color color);
  boolean canBePainted();
  Color getColor();
}
