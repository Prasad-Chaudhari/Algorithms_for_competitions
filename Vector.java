
class Vector {

    private class Point {

        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    Point r = new Point(0, 0, 0);

    //constructor
    public Vector(Point head, Point tail) {
        r.x = head.x - tail.x;
        r.y = head.y - tail.y;
        r.z = head.z - tail.z;
    }

    public Vector(Point head) {
        r = head;
    }

    //Methods
    public Point getVector() {
        return r;
    }

    public void print() {
        System.out.println("(" + r.x + "," + r.y + "," + r.z + ")");
    }

    public Vector subtract(Vector a) {
        Point b = a.getVector();
        return new Vector(r, b);
    }

    public int dotProduct(Vector b) {
        Point a2 = r;
        Point b2 = b.getVector();
        return a2.x * b2.x + a2.y * b2.y + a2.z * b2.z;
    }

    public Vector crossProduct(Vector b) {
        Point i = r;
        Point j = b.getVector();
        int x = i.y * j.z - i.z * j.y;
        int y = i.x * j.z - i.z * j.x;
        int z = i.x * j.y - i.y * j.x;
        return new Vector(new Point(x, y, z));
    }

    public boolean isNull() {
        return (r.x == 0 && r.y == 0 && r.z == 0);
    }

    public double length() {
        return Math.sqrt(Math.pow(r.x, 2) + Math.pow(r.y, 2) + Math.pow(r.y, 2));
    }

    public double angle(Vector v) {
        int cp = dotProduct(v);
        double lena = length();
        double lenb = v.length();
        return Math.acos(cp / (lena * lenb));
    }
}
