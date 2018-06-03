package com.epam.inner.training.service;

import com.epam.inner.training.model.material.IMaterial;
import com.epam.inner.training.model.shapes.AbstractShape;
import com.epam.inner.training.model.shapes.IShape;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Box {
  private final List<AbstractShape> shapes;
  private final List<HistoryEntry> history;

  public Box() {
    shapes = new LinkedList<>();
    history = new LinkedList<>();
  }


  public void addShape(AbstractShape shape){
    history.add(new HistoryEntry("Add new Shape", shape));
    shapes.add(shape);
  }
  public void addShapes(List<AbstractShape> shapes){
    history.add(new HistoryEntry("Add several shapes", shapes));
    this.shapes.addAll(shapes);
  }

  public List<AbstractShape> getShapesByMaterial(Class<? extends IMaterial> type){
    List<AbstractShape> shapes = this.shapes.stream().filter(shape -> shape.getMaterial().getClass().equals(type)).collect(Collectors.toList());
    this.shapes.removeAll(shapes);
    history.add(new HistoryEntry("Get shapes from box by material", type));
    return shapes;
  }

  public List<AbstractShape> getShapesByShape(Class<? extends AbstractShape> type){
    List<AbstractShape> shapes = this.shapes.stream().filter(shape -> shape.getClass().equals(type)).collect(Collectors.toList());
    this.shapes.removeAll(shapes);
    history.add(new HistoryEntry("Get shapes from box by shape type", type));
    return shapes;
  }

  public double calculateTotalArea(){
    double value = shapes.stream().mapToDouble(IShape::getArea).sum();
    history.add(new HistoryEntry("Calculated total area", value));
    return value;
  }

  public void printHistory(){
    history.forEach(System.out::println);
  }

  private class HistoryEntry {
    private String action;
    private Object subject;

    HistoryEntry(String action, Object subject) {
      this.action = action;
      this.subject = subject;
    }

    @Override
    public String toString() {
      return action + (subject != null ? " -> " + subject : "");
    }
  }
}
