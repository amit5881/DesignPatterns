// open and close + specification(design pattern)

import java.util.List;
import java.util.stream.Stream;

enum Color {
  RED, GREEN, BLUE
}

enum Size {
  SMALL, MEDIUM, LARGE, HUGE
}

class Product {
  public String name;
  public Color color;
  public Size size;

  public Product(String name, Color color, Size size) {
    this.name = name;
    this.color = color;
    this.size = size;
  }
}

/**
 * here we will have to add new code
 * everytime we need new filter
 */
class ProductFilter {

  public Stream<Product> filterByColor(List<Product> products, Color color) {
    return products.stream().filter(product -> product.color.equals(color));
  }

  public Stream<Product> filterBySize(List<Product> products, Size size) {
    return products.stream().filter(product -> product.size.equals(size));
  }

  public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
    return products.stream().filter(product -> product.color.equals(color) && product.size.equals(size));
  }
}

/**
 * Remedy for above problem
 * - add classes for each specification like size, color
 * and pass it to filter
 */
interface Specification<T> {
  boolean isSpecified(T item);
}

class ColorSpecification implements Specification<Product> {

  private Color color;

  public ColorSpecification(Color color) {
    this.color = color;
  }

  @Override
  public boolean isSpecified(Product item) {
    return item.color.equals(color);
  }
}

class SizeSpecification implements Specification<Product> {

  private Size size;

  public SizeSpecification(Size size) {
    this.size = size;
  }

  @Override
  public boolean isSpecified(Product item) {
    return item.size.equals(size);
  }
}

class TwoSpecification<T> implements Specification<T> {

  private Specification<T> first, second;

  public TwoSpecification(Specification<T> first, Specification<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean isSpecified(T item) {
    return first.isSpecified(item) && second.isSpecified(item);
  }
}

// filter by passing type of specification
interface Filter<T> {
  Stream<T> filter(List<T> items, Specification<T> specification);
}

class BetterFilter implements Filter<Product> {
  @Override
  public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
    return items.stream().filter(specification::isSpecified);
  }
}

public class Demo {

  public static void main(String[] args) {
    Product apple = new Product("Apple", Color.RED, Size.SMALL);
    Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
    Product house = new Product("House", Color.BLUE, Size.LARGE);

    List<Product> products = List.of(apple, tree, house);

//    ProductFilter productFilter = new ProductFilter();
//    Stream<Product> result = productFilter.filterByColor(products, Color.RED);
//    result.forEach(res -> System.out.println(res.name));

    BetterFilter filter = new BetterFilter();

    filter.filter(products, new ColorSpecification(Color.GREEN)).forEach(product -> System.out.println(product.name));
    System.out.println("=============");
    filter.filter(products, new SizeSpecification(Size.LARGE)).forEach(product -> System.out.println(product.name));
    System.out.println("%%%%%%%%%%%%%%%");

    filter.filter(
        products,
        new TwoSpecification<>(new SizeSpecification(Size.LARGE), new ColorSpecification(Color.BLUE)))
        .forEach(product -> System.out.println(product.name));
  }
}
