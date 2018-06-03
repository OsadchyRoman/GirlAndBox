package com.epam.inner.training.model.shapes;

import com.epam.inner.training.model.material.IMaterial;

public interface IMaterializedSahpe extends IShape {
  IMaterial getMaterial();
}
