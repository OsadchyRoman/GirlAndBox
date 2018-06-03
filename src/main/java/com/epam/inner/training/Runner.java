package com.epam.inner.training;

import com.epam.inner.training.model.color.Color;
import com.epam.inner.training.model.material.MaterialType;
import com.epam.inner.training.model.material.PaperMaterial;
import com.epam.inner.training.model.material.TapeMaterial;
import com.epam.inner.training.model.shapes.AbstractShape;
import com.epam.inner.training.service.Box;
import com.epam.inner.training.service.Girl;
import com.epam.inner.training.sheet.AbstractSheet;
import com.epam.inner.training.sheet.ISheet;
import com.epam.inner.training.sheet.PaperSheet;
import com.epam.inner.training.sheet.TapeSheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
  public static void main(String[] args) {
    Map<MaterialType, ISheet> sheets = new HashMap<>();

    sheets.put(MaterialType.PAPER, new PaperSheet());
    sheets.put(MaterialType.TAPE, new TapeSheet());

    Girl girl = new Girl(sheets);
    Box box = new Box();
    generateNewShapes(girl, box);

    box.printHistory();
    System.out.println("Total area before cut rectangles from shapes: " + box.calculateTotalArea());

    List<AbstractShape> shapes = box.getShapesByMaterial(PaperMaterial.class);
    List<AbstractShape> cutFromShapes = shapes.stream().map(girl::cutRectangleFromShape).collect(Collectors.toList());
    box.addShapes(cutFromShapes);
    System.out.println("Total area after cut rectangles from shapes: " + box.calculateTotalArea());
    box.printHistory();

    shapes = box.getShapesByMaterial(TapeMaterial.class);
    shapes.forEach(shape -> girl.paint(shape, Color.BLUE));
    box.addShapes(shapes);

    shapes = box.getShapesByMaterial(PaperMaterial.class);
    shapes.forEach(shape -> girl.paint(shape, Color.BLUE));
    box.addShapes(shapes);

    shapes = box.getShapesByMaterial(PaperMaterial.class);
    shapes.forEach(shape -> girl.paint(shape, Color.BLUE));
    box.addShapes(shapes);

    box.printHistory();
  }

  private static void generateNewShapes(Girl girl, Box box){
    box.addShape(girl.cutCircleFromSheetByType(MaterialType.PAPER, 10));
    box.addShape(girl.cutRectangleFromSheetByType(MaterialType.PAPER, 8, 15));
    box.addShape(girl.cutTriangleFromSheetByType(MaterialType.TAPE, 12));
    box.addShape(girl.cutSquareFromSheetByType(MaterialType.TAPE, 7));
    box.addShape(girl.cutCircleFromSheetByType(MaterialType.TAPE, 7));
    box.addShape(girl.cutRectangleFromSheetByType(MaterialType.PAPER, 7, 16));
    box.addShape(girl.cutTriangleFromSheetByType(MaterialType.TAPE, 17));
    box.addShape(girl.cutSquareFromSheetByType(MaterialType.PAPER, 11));
    box.addShape(girl.cutCircleFromSheetByType(MaterialType.TAPE, 3));
    box.addShape(girl.cutSquareFromSheetByType(MaterialType.PAPER, 9));
    box.addShape(girl.cutTriangleFromSheetByType(MaterialType.TAPE, 4));
  }



}
