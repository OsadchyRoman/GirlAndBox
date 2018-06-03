package com.epam.inner.training.sheet;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.Circle;
import com.epam.inner.training.model.shapes.Rectangle;
import com.epam.inner.training.model.shapes.Square;
import com.epam.inner.training.model.shapes.Triangle;
import com.epam.inner.training.model.shapes.params.CircleParameters;
import com.epam.inner.training.model.shapes.params.RectangleParameters;
import com.epam.inner.training.model.shapes.params.SquareParameters;
import com.epam.inner.training.model.shapes.params.TriangleParameters;

public abstract class AbstractSheet implements ISheet {

  @Override
  public Circle cutCircle(double radius) {
    return new Circle(getMaterial(), new CircleParameters(radius));
  }

  @Override
  public Triangle cutTriangle(double party) {
    return new Triangle(getMaterial(), new TriangleParameters(party));
  }

  @Override
  public Rectangle cutRectangle(double height, double width) {
    return new Rectangle(getMaterial(), new RectangleParameters(width, height));
  }

  @Override
  public Square cutSquare(double party) {
    return new Square(getMaterial(), new SquareParameters(party));
  }

  protected abstract IMaterial getMaterial();

}
