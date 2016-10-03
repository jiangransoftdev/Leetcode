public class SnakeGame {
    Deque<Integer> body;
    Set<Integer> set;
    int[][] food;
    int score,foodindex,width,height;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        body=new LinkedList<>();
        set=new HashSet<>();
        this.width=width;
        this.height=height;
        this.food=food;
        body.offerLast(0);
        set.add(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score==-1) return -1;
        int rowHead=body.peekFirst()/width;
        int colHead=body.peekFirst()%width;
        switch(direction){
            case "U":rowHead--;break;
            case "D":rowHead++;break;
            case "L":colHead--;break;
            default:colHead++;
        }
        int head=rowHead*width+colHead;
         set.remove(body.peekLast());
        if(rowHead<0||rowHead==height||colHead<0||colHead==width||set.contains(head)) return score=-1;
        set.add(head);
        body.offerFirst(head);
       
        if(foodindex<food.length&&rowHead==food[foodindex][0]&&colHead==food[foodindex][1]){
            foodindex++;
            set.add(body.peekLast());
            return ++score;
        }
        body.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */