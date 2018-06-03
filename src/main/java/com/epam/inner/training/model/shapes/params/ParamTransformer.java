package com.epam.inner.training.model.shapes.params;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ParamTransformer {

  private static final Map<String, List<Function<Double, Double>>> transformers = new HashMap<>();
  static {
    transformers.put("CircleParameters_to_RectangleParameters", Arrays.asList((a) -> 1D, (a) -> Math.sqrt(4*a*a - 1)));
    transformers.put("CircleParameters_to_SquareParameters", Collections.singletonList((a) -> (2 * a) / Math.sqrt(2)));
    transformers.put("CircleParameters_to_TriangleParameters", Collections.singletonList((a) -> a * Math.sqrt(3)));
    transformers.put("CircleParameters_to_CircleParameters", Collections.singletonList((a) -> a));

    transformers.put("RectangleParameters_to_CircleParameters", Collections.singletonList((a) -> a/2));
    transformers.put("RectangleParameters_to_SquareParameters", Collections.singletonList((a) -> a));
    transformers.put("RectangleParameters_to_TriangleParameters", Collections.singletonList((a) -> a));
    transformers.put("RectangleParameters_to_RectangleParameters", Arrays.asList((a) -> a, (a) -> a));

    transformers.put("SquareParameters_to_CircleParameters", Collections.singletonList((a) -> a));
    transformers.put("SquareParameters_to_SquareParameters", Collections.singletonList((a) -> a));
    transformers.put("SquareParameters_to_TriangleParameters", Collections.singletonList((a) -> a / 2));
    transformers.put("SquareParameters_to_RectangleParameters", Arrays.asList((a) -> a, (a) -> a/2));

    transformers.put("TriangleParameters_to_CircleParameters", Collections.singletonList((a) -> a / (2 * Math.sqrt(3))));
    transformers.put("TriangleParameters_to_SquareParameters", Collections.singletonList((a) -> a * Math.sqrt(3) / (2 + Math.sqrt(3))));
    transformers.put("TriangleParameters_to_TriangleParameters", Collections.singletonList((a) -> a));
    transformers.put("TriangleParameters_to_RectangleParameters", Arrays.asList((a) -> a * Math.sqrt(3) / (2 + Math.sqrt(3)), (a) -> a * Math.sqrt(3) / (2 + Math.sqrt(3))));
  }

  private final Iterator<Function<Double, Double>> functions;
  private final Iterator<Double> params;

  private ParamTransformer(Iterator<Function<Double, Double>> functions, Iterator<Double> params) {
    this.functions = functions;
    this.params = params;
  }

  public double next(){
    Double value;
    if (params.hasNext()){
      value = params.next();
    } else {
      throw new RuntimeException("The transformation is completed, there is no more values to process");
    }
    if (functions.hasNext()){
      return functions.next().apply(value);
    } else {
      throw new RuntimeException("The transformation is completed, there is no more functions to process");
    }
  }

  public static ParamTransformer getTransformer(Class<? extends IShapeParameters> from, Class<? extends IShapeParameters> to, Double[] params) {
    String key = from.getSimpleName() + "_to_" + to.getSimpleName();
    if (transformers.containsKey(key)) {
      return new ParamTransformer(transformers.get(key).iterator(), Arrays.asList(params).iterator());
    } else {
      throw new RuntimeException("The parameter transformer doesn't exist: " + key);
    }
  }
}
