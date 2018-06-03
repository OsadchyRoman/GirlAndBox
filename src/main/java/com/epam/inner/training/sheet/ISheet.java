package com.epam.inner.training.sheet;

import com.epam.inner.training.model.shapes.Circle;
import com.epam.inner.training.model.shapes.Rectangle;
import com.epam.inner.training.model.shapes.Square;
import com.epam.inner.training.model.shapes.Triangle;

public interface ISheet {
  Circle cutCircle(double radius);
  Triangle cutTriangle(double party);
  Rectangle cutRectangle(double height, double width);
  Square cutSquare(double party);
}
