package helpers;

/**
 * Encapsulates a 2D vector. Allows chaining methods by returning a reference to itself
 *
 * @author badlogicgames@gmail.com
 */
public class Vector2 {
    public final static Vector2 X = new Vector2(1, 0);
    public final static Vector2 Y = new Vector2(0, 1);
    public final static Vector2 Zero = new Vector2(0, 0);

    /**
     * the x-component of this vector
     **/
    public float x;
    /**
     * the y-component of this vector
     **/
    public float y;

    /**
     * Constructs a new vector at (0,0)
     */
    public Vector2() {
    }

    /**
     * Constructs a vector with the given components
     *
     * @param x The x-component
     * @param y The y-component
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a vector from the given vector
     *
     * @param v The vector
     */
    public Vector2(Vector2 v) {
        set(v);
    }

    public static float len(float x, float y) {
        return (float) Math.sqrt(x * x + y * y);
    }

    public static float len2(float x, float y) {
        return x * x + y * y;
    }

    public static float dot(float x1, float y1, float x2, float y2) {
        return x1 * x2 + y1 * y2;
    }

    public static float dst(float x1, float y1, float x2, float y2) {
        final float x_d = x2 - x1;
        final float y_d = y2 - y1;
        return (float) Math.sqrt(x_d * x_d + y_d * y_d);
    }

    public static float dst2(float x1, float y1, float x2, float y2) {
        final float x_d = x2 - x1;
        final float y_d = y2 - y1;
        return x_d * x_d + y_d * y_d;
    }

    public Vector2 cpy() {
        return new Vector2(this);
    }

    public float len() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float len2() {
        return x * x + y * y;
    }

    public Vector2 set(Vector2 v) {
        x = v.x;
        y = v.y;
        return this;
    }

    /**
     * Sets the components of this vector
     *
     * @param x The x-component
     * @param y The y-component
     * @return This vector for chaining
     */
    public Vector2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2 sub(Vector2 v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    /**
     * Substracts the other vector from this vector.
     *
     * @param x The x-component of the other vector
     * @param y The y-component of the other vector
     * @return This vector for chaining
     */
    public Vector2 sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2 nor() {
        float len = len();
        if (len != 0) {
            x /= len;
            y /= len;
        }
        return this;
    }

    public Vector2 add(Vector2 v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Adds the given components to this vector
     *
     * @param x The x-component
     * @param y The y-component
     * @return This vector for chaining
     */
    public Vector2 add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public float dot(Vector2 v) {
        return x * v.x + y * v.y;
    }

    public float dot(float ox, float oy) {
        return x * ox + y * oy;
    }

    public Vector2 scl(float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    /**
     * Multiplies this vector by a scalar
     *
     * @return This vector for chaining
     */
    public Vector2 scl(float x, float y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2 scl(Vector2 v) {
        this.x *= v.x;
        this.y *= v.y;
        return this;
    }

    public Vector2 mulAdd(Vector2 vec, float scalar) {
        this.x += vec.x * scalar;
        this.y += vec.y * scalar;
        return this;
    }

    public Vector2 mulAdd(Vector2 vec, Vector2 mulVec) {
        this.x += vec.x * mulVec.x;
        this.y += vec.y * mulVec.y;
        return this;
    }

    public float dst(Vector2 v) {
        final float x_d = v.x - x;
        final float y_d = v.y - y;
        return (float) Math.sqrt(x_d * x_d + y_d * y_d);
    }

    /**
     * @param x The x-component of the other vector
     * @param y The y-component of the other vector
     * @return the distance between this and the other vector
     */
    public float dst(float x, float y) {
        final float x_d = x - this.x;
        final float y_d = y - this.y;
        return (float) Math.sqrt(x_d * x_d + y_d * y_d);
    }

    public float dst2(Vector2 v) {
        final float x_d = v.x - x;
        final float y_d = v.y - y;
        return x_d * x_d + y_d * y_d;
    }

    /**
     * @param x The x-component of the other vector
     * @param y The y-component of the other vector
     * @return the squared distance between this and the other vector
     */
    public float dst2(float x, float y) {
        final float x_d = x - this.x;
        final float y_d = y - this.y;
        return x_d * x_d + y_d * y_d;
    }

    public Vector2 clamp(float min, float max) {
        final float len2 = len2();
        if (len2 == 0f) return this;
        float max2 = max * max;
        if (len2 > max2) return scl((float) Math.sqrt(max2 / len2));
        float min2 = min * min;
        if (len2 < min2) return scl((float) Math.sqrt(min2 / len2));
        return this;
    }

    public Vector2 setLength(float len) {
        return setLength2(len * len);
    }

    public Vector2 setLength2(float len2) {
        float oldLen2 = len2();
        return (oldLen2 == 0 || oldLen2 == len2) ? this : scl((float) Math.sqrt(len2 / oldLen2));
    }

    /**
     * Converts this {@code helpers.Vector2} to a string in the format {@code (x,y)}.
     *
     * @return a string representation of this object.
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Sets this {@code helpers.Vector2} to the value represented by the specified string according to the format of {@link #toString()}.
     *
     * @param v the string.
     * @return this vector for chaining
     */
    public Vector2 fromString(String v) {
        int s = v.indexOf(',', 1);
        if (s != -1 && v.charAt(0) == '(' && v.charAt(v.length() - 1) == ')') {
            try {
                float x = Float.parseFloat(v.substring(1, s));
                float y = Float.parseFloat(v.substring(s + 1, v.length() - 1));
                return this.set(x, y);
            } catch (NumberFormatException ex) {
                // Throw a GdxRuntimeException
            }
        }
        throw new RuntimeException("Malformed helpers.Vector2: " + v);
    }


    /**
     * Rotates the helpers.Vector2 by 90 degrees in the specified direction, where >= 0 is counter-clockwise and < 0 is clockwise.
     */
    public Vector2 rotate90(int dir) {
        float x = this.x;
        if (dir >= 0) {
            this.x = -y;
            y = x;
        } else {
            this.x = y;
            y = -x;
        }
        return this;
    }

    public Vector2 lerp(Vector2 target, float alpha) {
        final float invAlpha = 1.0f - alpha;
        this.x = (x * invAlpha) + (target.x * alpha);
        this.y = (y * invAlpha) + (target.y * alpha);
        return this;
    }

    public boolean isUnit() {
        return isUnit(0.000000001f);
    }

    public boolean isUnit(final float margin) {
        return Math.abs(len2() - 1f) < margin;
    }

    public boolean isZero() {
        return x == 0 && y == 0;
    }

    public boolean isZero(final float margin) {
        return len2() < margin;
    }

    public boolean hasSameDirection(Vector2 vector) {
        return dot(vector) > 0;
    }

    public boolean hasOppositeDirection(Vector2 vector) {
        return dot(vector) < 0;
    }

    public Vector2 setZero() {
        this.x = 0;
        this.y = 0;
        return this;
    }
}