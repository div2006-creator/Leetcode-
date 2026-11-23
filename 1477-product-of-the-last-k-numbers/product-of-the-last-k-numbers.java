class ProductOfNumbers {
ArrayList <Integer> list;
    public ProductOfNumbers() {
      list = new ArrayList<>();  
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int m) {
        int k = 1;
        for (int i = list.size() - m; i < list.size(); i++) {
        k *= list.get(i); 
        }
        return k;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */