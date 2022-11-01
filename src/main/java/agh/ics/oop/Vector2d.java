package agh.ics.oop;

class Vector2d {
    int x;
    int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }
    boolean precedes(Vector2d other){
        if(other.x >= this.x && other.y >= this.y){
            return true;
        }
        return false;
    }
    boolean follows(Vector2d other){
        if(other.x <= this.x && other.y <= this.y){
            return true;
        }
        else
            return false;
    }
    Vector2d upperRight(Vector2d other){
        Vector2d result = new Vector2d(this.x,this.y);
        if (other.x > this.x){
            result.x = other.x;
        }
        if (other.y > this.y){
            result.y = other.y;

        }
        return result;
    }

    Vector2d lowerLeft(Vector2d other){
        Vector2d result = new Vector2d(this.x,this.y);
        if (other.x < this.x){
            result.x = other.x;
        }
        if (other.y < this.y){
            result.y = other.y;
        }
        return result;
    }

    Vector2d add(Vector2d other){
        Vector2d result = new Vector2d(this.x,this.y);
        result.x += other.x;
        result.y += other.y;
        return result;
    }
    Vector2d subtract(Vector2d other){
        Vector2d result = new Vector2d(this.x,this.y);
        result.x -= other.x;
        result.y -= other.y;
        return result;
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        else {
            Vector2d that = (Vector2d) other;
            if (this.x != that.x) {
                return false;
            }
            if (this.y != that.y) {
                return false;
            }
            return true;
        }
    }

    Vector2d opposite(){
        Vector2d result = new Vector2d(this.y,this.x);
        return result;
    }

}
