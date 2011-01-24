package com.github.noxan.jtdge.geom;

import java.awt.Point;
import java.io.Serializable;

/**
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.6b2(r10)
 */
public abstract class Point2D implements Cloneable {
	/**
	 * @author  richard
	 */
	public static class Integer extends Point2D implements Serializable {
		private static final long serialVersionUID = -7288669135763086524L;
		
		/**
		 * @uml.property  name="x"
		 */
		public int x;
		/**
		 * @uml.property  name="y"
		 */
		public int y;
		
		public Integer() {
			this(0, 0);
		}
		public Integer(Point p) {
			this(p.x, p.y);
		}
		public Integer(int x, int y) {
			setLocation(x, y);
		}
		
		/**
		 * @return
		 * @uml.property  name="x"
		 */
		@Override
		public double getX() {
			return x;
		}
		@Override
		public void setX(double x) {
			this.x = (int)x;
		}
		/**
		 * @return
		 * @uml.property  name="y"
		 */
		@Override
		public double getY() {
			return y;
		}
		@Override
		public void setY(double y) {
			this.y = (int)y;
		}
		
		@Override
		public void setLocation(double x, double y) {
			setLocation((int)x, (int)y);
		}
		public void setLocation(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public Point2D getLocation() {
			return new Point2D.Integer(x, y);
		}
		
		@Override
		public Point2D.Integer translate(double x, double y) {
			return new Point2D.Integer((int)(getX()+x), (int)(getY()+y));
		}
		
		@Override
		public String toString() {
			return "Point2D.Integer["+x+", "+y+"]";
		}
	}
	
	/**
	 * @author  richard
	 */
	public static class Float extends Point2D implements Serializable {
		private static final long serialVersionUID = -7288669135763086524L;
		
		/**
		 * @uml.property  name="x"
		 */
		public float x;
		/**
		 * @uml.property  name="y"
		 */
		public float y;
		
		public Float() {
		}
		public Float(float x, float y) {
			setLocation(x, y);
		}
		
		/**
		 * @return
		 * @uml.property  name="x"
		 */
		@Override
		public double getX() {
			return x;
		}
		@Override
		public void setX(double x) {
			this.x = (int)x;
		}
		/**
		 * @return
		 * @uml.property  name="y"
		 */
		@Override
		public double getY() {
			return y;
		}
		@Override
		public void setY(double y) {
			this.y = (int)y;
		}
		
		@Override
		public void setLocation(double x, double y) {
			setLocation((float)x, (float)y);
		}
		public void setLocation(float x, float y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public Point2D getLocation() {
			return new Point2D.Float(x, y);
		}
		
		@Override
		public Point2D.Float translate(double x, double y) {
			return new Point2D.Float((float)(getX()+x), (float)(getY()+y));
		}
		
		@Override
		public String toString() {
			return "Point2D.Float["+x+", "+y+"]";
		}
	}
	
	protected Point2D() {
	}
	
	public abstract double getX();
	public abstract void setX(double x);
	public abstract double getY();
	public abstract void setY(double y);
	
	/**
	 * @uml.property  name="location"
	 * @uml.associationEnd  readOnly="true"
	 */
	public abstract Point2D getLocation();
	public void setLocation(Point2D p) {
		setLocation(p.getX(), p.getY());
	}
	public abstract void setLocation(double x, double y);
	
	public abstract Point2D translate(double x, double y);
	
	public static double distanceSquare(double x1, double y1, double x2, double y2) {
		x1 = x1-x2;
		y1 = y1-y2;
		return (x1*x1+y1*y1);
	}
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(distanceSquare(x1, y1, x2, y2));
	}
	
	public double distanceSquare(double px, double py) {
		return distanceSquare(getX(), getY(), px, py);
	}
	public double distanceSquare(Point2D p) {
		return distanceSquare(getX(), getY(), p.getX(), p.getY());
	}
	public double distance(double px, double py) {
		return distance(getX(), getY(), px, py);
	}
	public double distance(Point2D p) {
		return distance(getX(), getY(), p.getX(), p.getY());
	}
	
	public Object clone() {
		try {
			return super.clone();
		} catch(CloneNotSupportedException e) {
			throw new InternalError();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point2D) {
			Point2D p = (Point2D) obj;
			return (getX()==p.getX()&&getY()==p.getY());
		}
		return super.equals(obj);
	}
}
