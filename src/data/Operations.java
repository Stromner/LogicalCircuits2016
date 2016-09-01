package data;

/**
 * Enum for all the basic boolean operations.
 * Example on usage: Operations.AND.apply(1,1);
 * 
 * @author David Strömner
 */

public enum Operations {
	AND() {
		@Override
		public int apply(int x1, int x2) {
			return x1 & x2;
		}
	},
	OR() {
		@Override
		public int apply(int x1, int x2) {
			return x1 | x2;
		}
	},
	XOR() {
		@Override
		public int apply(int x1, int x2) {
			return x1 ^ x2;
		}
	},
	NOT() {
		@Override
		public int apply(int x1, int x2) {
			return 1-x1;
		}
	};

	public abstract int apply(int x1, int x2);
}
