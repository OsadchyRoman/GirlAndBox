package com.epam.inner.training.service;

import com.epam.inner.training.model.color.Color;
import com.epam.inner.training.model.material.MaterialType;
import com.epam.inner.training.model.shapes.AbstractShape;
import com.epam.inner.training.model.shapes.Circle;
import com.epam.inner.training.model.shapes.IColoredShape;
import com.epam.inner.training.model.shapes.Rectangle;
import com.epam.inner.training.model.shapes.Square;
import com.epam.inner.training.model.shapes.Triangle;
import com.epam.inner.training.sheet.ISheet;

import java.util.Map;

public class Girl {

  private final Map<MaterialType, ISheet> sheetMap;


  public Girl(Map<MaterialType, ISheet> sheetMap) {
    this.sheetMap = sheetMap;
  }

  public Circle cutCircleFromSheetByType(MaterialType type, double radius) {
    ISheet sheet = sheetMap.get(type);
    return sheet.cutCircle(radius);
  }
  public Triangle cutTriangleFromSheetByType(MaterialType type, double party){
    ISheet sheet = sheetMap.get(type);
    return sheet.cutTriangle(party);
  }
  public Rectangle cutRectangleFromSheetByType(MaterialType type, double width, double height){
    ISheet sheet = sheetMap.get(type);
    return sheet.cutRectangle(height, width);
  }
  public Square cutSquareFromSheetByType(MaterialType type, double party){
    ISheet sheet = sheetMap.get(type);
    return sheet.cutSquare(party);
  }

  public Circle cutCircleFromShape(AbstractShape shape) {
    return new Circle(shape);
  }
  public Triangle cutTriangleFromShape(AbstractShape shape){
    return new Triangle(shape);
  }
  public Rectangle cutRectangleFromShape(AbstractShape shape){
    return new Rectangle(shape);
  }
  public Square cutSquareFromShape(AbstractShape shape){
    return new Square(shape);
  }

  public void paint(IColoredShape shape, Color color){
    if (shape.canBePainted()){
      shape.paint(color);
    } else {
      System.err.println("The shape: " + shape + " can't be painted");
    }
  }
}
