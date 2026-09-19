class MedianFinder {
    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;

    public MedianFinder() {
        first = new PriorityQueue<>((a, b) -> b - a);
        second = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (second.size() >= 1 && num < second.peek())
            first.add(num);
        else
            second.add(num);

        if (first.size() - second.size() > 1) {
            second.add(first.poll());
        } else if (second.size() - first.size() > 1) {
            first.add(second.poll());
        }
    }

    public double findMedian() {
        if (first.size() >= 1 && first.size() == second.size())
            return (double) (first.peek() + second.peek()) / 2;
        else
            return first.size() > second.size() ? (double) first.peek() : second.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */