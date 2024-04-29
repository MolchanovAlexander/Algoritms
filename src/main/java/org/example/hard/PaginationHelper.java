package org.example.hard;

import java.util.List;

public class PaginationHelper<T> {
  private final int itemsPerPage;
  private final List<T> collection;

  public PaginationHelper(List<T> collection, int itemsPerPage) {
    this.itemsPerPage = itemsPerPage;
    this.collection = collection;
  }

  public int itemCount() {
    return collection.size();
  }

  public int pageCount() {
    return (int)Math.ceil(itemCount() / (float)itemsPerPage);
  }

  public int pageItemCount(int pageIndex) {
    if (pageIndex >= pageCount() || pageIndex < 0) {
      return -1;
    }
    if (pageIndex < pageCount() - 1) {
      return itemsPerPage;
    }
    return itemCount() % itemsPerPage;
  }

  public int pageIndex(int itemIndex) {
    if (itemIndex >= itemCount() || itemIndex < 0) {
      return -1;
    }
    return itemIndex / itemsPerPage;
  }
}
