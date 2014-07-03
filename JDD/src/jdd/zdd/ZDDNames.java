
package jdd.zdd;

import jdd.util.*;

/*
 * Helper class for giving name to Z-BDD nodes.
 *
 * @see NodeName
 */

public class ZDDNames implements  NodeName {

	public String zero() { return "emptyset"; }
	public String one() { return "base"; }
	public String zeroShort() { return "{}"; }
	public String oneShort() { return "{{}}"; }

	public String variable(int n) {
		if(n < 0) return "(none)";
		return "v" + (n + 1);
	}
}
