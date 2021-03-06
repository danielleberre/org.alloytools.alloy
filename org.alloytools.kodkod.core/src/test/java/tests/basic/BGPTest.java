package tests.basic;

import java.util.Arrays;
import java.util.List;

import kodkod.ast.Decls;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntExpression;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.ast.operator.FormulaOperator;
import kodkod.engine.Evaluator;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.config.ConsoleReporter;
import kodkod.engine.config.Options;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Universe;
import kodkod.util.nodes.PrettyPrinter;

public final class BGPTest {

	public static void main(String[] args) throws Exception {

		Relation x0 = Relation.unary("Int/min");
		Relation x1 = Relation.unary("Int/zero");
		Relation x2 = Relation.unary("Int/max");
		Relation x3 = Relation.nary("Int/next", 2);
		Relation x4 = Relation.unary("seq/Int");
		Relation x5 = Relation.unary("String");
		Relation x6 = Relation.unary("this/Natural");
		Relation x7 = Relation.unary("ord/Ord");
		Relation x8 = Relation.unary("this/Zero");
		Relation x9 = Relation.unary("this/One");
		Relation x10 = Relation.nary("this/Natural.data", 4);
		Relation x11 = Relation.unary("ord/Ord.First");
		Relation x12 = Relation.nary("ord/Ord.Next", 2);
		Relation x13 = Relation.unary("");

		List<String> atomlist = Arrays.asList("-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "0", "1", "2", "3", "4",
				"5", "6", "7", "Natural$0", "Natural$1", "Natural$2", "Natural$3", "ord/Ord$0");

		Universe universe = new Universe(atomlist);
		TupleFactory factory = universe.factory();
		Bounds bounds = new Bounds(universe);

		TupleSet x0_upper = factory.noneOf(1);
		x0_upper.add(factory.tuple("-8"));
		bounds.boundExactly(x0, x0_upper);

		TupleSet x1_upper = factory.noneOf(1);
		x1_upper.add(factory.tuple("0"));
		bounds.boundExactly(x1, x1_upper);

		TupleSet x2_upper = factory.noneOf(1);
		x2_upper.add(factory.tuple("7"));
		bounds.boundExactly(x2, x2_upper);

		TupleSet x3_upper = factory.noneOf(2);
		x3_upper.add(factory.tuple("-8").product(factory.tuple("-7")));
		x3_upper.add(factory.tuple("-7").product(factory.tuple("-6")));
		x3_upper.add(factory.tuple("-6").product(factory.tuple("-5")));
		x3_upper.add(factory.tuple("-5").product(factory.tuple("-4")));
		x3_upper.add(factory.tuple("-4").product(factory.tuple("-3")));
		x3_upper.add(factory.tuple("-3").product(factory.tuple("-2")));
		x3_upper.add(factory.tuple("-2").product(factory.tuple("-1")));
		x3_upper.add(factory.tuple("-1").product(factory.tuple("0")));
		x3_upper.add(factory.tuple("0").product(factory.tuple("1")));
		x3_upper.add(factory.tuple("1").product(factory.tuple("2")));
		x3_upper.add(factory.tuple("2").product(factory.tuple("3")));
		x3_upper.add(factory.tuple("3").product(factory.tuple("4")));
		x3_upper.add(factory.tuple("4").product(factory.tuple("5")));
		x3_upper.add(factory.tuple("5").product(factory.tuple("6")));
		x3_upper.add(factory.tuple("6").product(factory.tuple("7")));
		bounds.boundExactly(x3, x3_upper);

		TupleSet x4_upper = factory.noneOf(1);
		x4_upper.add(factory.tuple("0"));
		x4_upper.add(factory.tuple("1"));
		x4_upper.add(factory.tuple("2"));
		x4_upper.add(factory.tuple("3"));
		bounds.boundExactly(x4, x4_upper);

		TupleSet x5_upper = factory.noneOf(1);
		bounds.boundExactly(x5, x5_upper);

		TupleSet x6_upper = factory.noneOf(1);
		x6_upper.add(factory.tuple("Natural$0"));
		x6_upper.add(factory.tuple("Natural$1"));
		x6_upper.add(factory.tuple("Natural$2"));
		x6_upper.add(factory.tuple("Natural$3"));
		bounds.boundExactly(x6, x6_upper);

		TupleSet x7_upper = factory.noneOf(1);
		x7_upper.add(factory.tuple("ord/Ord$0"));
		bounds.boundExactly(x7, x7_upper);

		TupleSet x8_upper = factory.noneOf(1);
		x8_upper.add(factory.tuple("Natural$0"));
		x8_upper.add(factory.tuple("Natural$1"));
		x8_upper.add(factory.tuple("Natural$2"));
		x8_upper.add(factory.tuple("Natural$3"));
		bounds.bound(x8, x8_upper);

		TupleSet x9_upper = factory.noneOf(1);
		x9_upper.add(factory.tuple("Natural$0"));
		x9_upper.add(factory.tuple("Natural$1"));
		x9_upper.add(factory.tuple("Natural$2"));
		x9_upper.add(factory.tuple("Natural$3"));
		bounds.bound(x9, x9_upper);

		TupleSet x10_upper = factory.noneOf(4);
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$0")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$1")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$2")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2"))
				.product(factory.tuple("Natural$3")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$0")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$1")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$2")));
		x10_upper.add(factory.tuple("Natural$3")
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3"))
				.product(factory.tuple("Natural$3")));
		bounds.bound(x10, x10_upper);

		TupleSet x11_upper = factory.noneOf(1);
		x11_upper.add(factory.tuple("Natural$0"));
		x11_upper.add(factory.tuple("Natural$1"));
		x11_upper.add(factory.tuple("Natural$2"));
		x11_upper.add(factory.tuple("Natural$3"));
		bounds.bound(x11, x11_upper);

		TupleSet x12_upper = factory.noneOf(2);
		x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$0")));
		x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$1")));
		x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$2")));
		x12_upper.add(factory.tuple("Natural$0").product(factory.tuple("Natural$3")));
		x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$0")));
		x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$1")));
		x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$2")));
		x12_upper.add(factory.tuple("Natural$1").product(factory.tuple("Natural$3")));
		x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$0")));
		x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$1")));
		x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$2")));
		x12_upper.add(factory.tuple("Natural$2").product(factory.tuple("Natural$3")));
		x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$0")));
		x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$1")));
		x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$2")));
		x12_upper.add(factory.tuple("Natural$3").product(factory.tuple("Natural$3")));
		bounds.bound(x12, x12_upper);

		TupleSet x13_upper = factory.noneOf(1);
		x13_upper.add(factory.tuple("Natural$0"));
		x13_upper.add(factory.tuple("Natural$1"));
		x13_upper.add(factory.tuple("Natural$2"));
		x13_upper.add(factory.tuple("Natural$3"));
		bounds.bound(x13, x13_upper);

		bounds.boundExactly(-8, factory.range(factory.tuple("-8"), factory.tuple("-8")));
		bounds.boundExactly(-7, factory.range(factory.tuple("-7"), factory.tuple("-7")));
		bounds.boundExactly(-6, factory.range(factory.tuple("-6"), factory.tuple("-6")));
		bounds.boundExactly(-5, factory.range(factory.tuple("-5"), factory.tuple("-5")));
		bounds.boundExactly(-4, factory.range(factory.tuple("-4"), factory.tuple("-4")));
		bounds.boundExactly(-3, factory.range(factory.tuple("-3"), factory.tuple("-3")));
		bounds.boundExactly(-2, factory.range(factory.tuple("-2"), factory.tuple("-2")));
		bounds.boundExactly(-1, factory.range(factory.tuple("-1"), factory.tuple("-1")));
		bounds.boundExactly(0, factory.range(factory.tuple("0"), factory.tuple("0")));
		bounds.boundExactly(1, factory.range(factory.tuple("1"), factory.tuple("1")));
		bounds.boundExactly(2, factory.range(factory.tuple("2"), factory.tuple("2")));
		bounds.boundExactly(3, factory.range(factory.tuple("3"), factory.tuple("3")));
		bounds.boundExactly(4, factory.range(factory.tuple("4"), factory.tuple("4")));
		bounds.boundExactly(5, factory.range(factory.tuple("5"), factory.tuple("5")));
		bounds.boundExactly(6, factory.range(factory.tuple("6"), factory.tuple("6")));
		bounds.boundExactly(7, factory.range(factory.tuple("7"), factory.tuple("7")));

		Formula x15 = x8.in(x6);
		Formula x16 = x9.in(x6);
		Formula x17 = x8.one();
		Formula x18 = x9.lone();
		Variable x21 = Variable.unary("checkOneSolvable3ToNinjaWheel_this");
		Decls x20 = x21.oneOf(x6);
		Expression x23 = x21.join(x10);
		Expression x25 = x6.product(x6);
		Expression x24 = x6.product(x25);
		Formula x22 = x23.in(x24);
		Formula x19 = x22.forAll(x20);
		Expression x29 = x10.join(Expression.UNIV);
		Expression x28 = x29.join(Expression.UNIV);
		Expression x27 = x28.join(Expression.UNIV);
		Formula x26 = x27.in(x6);
		Expression x33 = x7.product(x11);
		Expression x32 = x7.join(x33);
		Formula x31 = x32.in(x6);
		Expression x36 = x7.product(x12);
		Expression x35 = x7.join(x36);
		Expression x37 = x6.product(x6);
		Formula x34 = x35.in(x37);
		Formula x38 = x12.totalOrder(x6, x11, x13);
		Formula x39 = x11.in(x8);
		Expression x41 = x11.join(x12);
		Formula x40 = x41.in(x9);
		Expression x46 = x10.join(x6);
		Expression x45 = x46.join(x6);
		Expression x44 = x45.join(x6);
		Expression x47 = x44.join(x12);
		Expression x43 = x44.difference(x47);
		Formula x42 = x43.in(x11);
		Variable x50 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
		Decls x49 = x50.oneOf(x6);
		Expression x55 = x50.join(x10);
		Expression x54 = x55.join(x6);
		Expression x53 = x54.join(x6);
		Expression x56 = x53.join(x12);
		Expression x52 = x53.difference(x56);
		Formula x51 = x52.in(x11);
		Formula x48 = x51.forAll(x49);
		Variable x59 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
		Decls x58 = x59.oneOf(x6);
		Variable x62 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathPref");
		Decls x61 = x62.oneOf(x6);
		Expression x67 = x59.join(x10);
		Expression x66 = x62.join(x67);
		Expression x65 = x66.join(x6);
		Expression x68 = x65.join(x12);
		Expression x64 = x65.difference(x68);
		Formula x63 = x64.in(x11);
		Formula x60 = x63.forAll(x61);
		Formula x57 = x60.forAll(x58);
		Variable x71 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
		Decls x70 = x71.oneOf(x6);
		Variable x74 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathPref");
		Decls x73 = x74.oneOf(x6);
		Variable x77 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathIndex");
		Decls x76 = x77.oneOf(x6);
		Expression x81 = x71.join(x10);
		Expression x80 = x74.join(x81);
		Expression x79 = x77.join(x80);
		Formula x78 = x79.lone();
		Formula x75 = x78.forAll(x76);
		Formula x72 = x75.forAll(x73);
		Formula x69 = x72.forAll(x70);
		Variable x84 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
		Decls x83 = x84.oneOf(x44);
		Expression x86 = x84.join(x10);
		Formula x85 = x86.some();
		Formula x82 = x85.forAll(x83);
		Variable x89 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
		Decls x88 = x89.oneOf(x44);
		Variable x92 = Variable.unary("checkOneSolvable3ToNinjaWheel_pathPref");
		Expression x95 = x89.join(x10);
		Expression x94 = x95.join(x6);
		Expression x93 = x94.join(x6);
		Decls x91 = x92.oneOf(x93);
		Expression x101 = x89.join(x10);
		Expression x100 = x92.join(x101);
		Expression x99 = x6.join(x100);
		Formula x98 = x99.in(x44);
		Expression x104 = x100.join(x6);
		IntExpression x103 = x104.count();
		Expression x106 = x6.join(x100);
		IntExpression x105 = x106.count();
		Formula x102 = x103.eq(x105);
		Formula x97 = x98.and(x102);
		Expression x108 = x8.join(x100);
		Formula x107 = x108.eq(x89);
		Formula x96 = x97.and(x107);
		Formula x90 = x96.forAll(x91);
		Formula x87 = x90.forAll(x88);
		Variable x111 = Variable.unary("checkOneSolvable3ToNinjaWheel_node");
		Decls x110 = x111.oneOf(x44);
		Variable x115 = Variable.unary("checkOneSolvable3ToNinjaWheel_i");
		Expression x118 = x111.join(x10);
		Expression x117 = x118.join(x6);
		Expression x116 = x117.join(x6);
		Decls x114 = x115.oneOf(x116);
		Variable x120 = Variable.unary("checkOneSolvable3ToNinjaWheel_j");
		Decls x119 = x120.oneOf(x116);
		Decls x113 = x114.and(x119);
		Expression x124 = x115.intersection(x120);
		Formula x123 = x124.no();
		Expression x127 = x111.join(x10);
		Expression x126 = x115.join(x127);
		Expression x129 = x111.join(x10);
		Expression x128 = x120.join(x129);
		Formula x125 = x126.eq(x128);
		Formula x122 = x123.and(x125);
		Formula x121 = x122.not();
		Formula x112 = x121.forAll(x113);
		Formula x109 = x112.forAll(x110);
		Expression x134 = x6.join(x10);
		Expression x133 = x134.join(x6);
		Expression x132 = x133.join(x6);
		IntExpression x131 = x132.count();
		IntExpression x135 = x6.count();
		Formula x130 = x131.lt(x135);
		IntExpression x141 = x44.count();
		Expression x140 = x141.toExpression();
		IntExpression x143 = IntConstant.constant(3);
		Expression x142 = x143.toExpression();
		Formula x139 = x140.eq(x142);
		Formula x138 = x139.not();
		Variable x149 = Variable.unary("oneSolvableFun3_i1");
		Decls x148 = x149.oneOf(x6);
		Variable x151 = Variable.unary("oneSolvableFun3_i2");
		Decls x150 = x151.oneOf(x6);
		Variable x153 = Variable.unary("oneSolvableFun3_i3");
		Decls x152 = x153.oneOf(x6);
		Decls x147 = x148.and(x150).and(x152);
		Expression x160 = x8.join(x10);
		Expression x159 = x160.join(x6);
		Expression x158 = x159.join(x6);
		Expression x165 = x8.join(x10);
		Expression x164 = x165.join(x6);
		Expression x163 = x164.join(x6);
		Expression x168 = x12.transpose();
		Expression x167 = x168.closure();
		Expression x166 = x163.join(x167);
		Expression x162 = x163.difference(x166);
		Expression x161 = x162.join(x12);
		Expression x157 = x158.union(x161);
		Formula x156 = x149.in(x157);
		Expression x174 = x9.join(x10);
		Expression x173 = x174.join(x6);
		Expression x172 = x173.join(x6);
		Expression x179 = x9.join(x10);
		Expression x178 = x179.join(x6);
		Expression x177 = x178.join(x6);
		Expression x182 = x12.transpose();
		Expression x181 = x182.closure();
		Expression x180 = x177.join(x181);
		Expression x176 = x177.difference(x180);
		Expression x175 = x176.join(x12);
		Expression x171 = x172.union(x175);
		Formula x170 = x151.in(x171);
		Expression x186 = x8.product(x149);
		Expression x187 = x9.product(x151);
		Expression x185 = x186.union(x187);
		Expression x189 = x9.join(x12);
		Expression x188 = x189.product(x153);
		Expression x184 = x185.union(x188);
		Variable x193 = Variable.unary("ValidBest_node");
		Decls x192 = x193.oneOf(x6);
		Variable x195 = Variable.unary("ValidBest_pref");
		Decls x194 = x195.oneOf(x6);
		Decls x191 = x192.and(x194);
		Variable x202 = Variable.unary("ValidChoices_n");
		Decls x201 = x202.oneOf(x6);
		Variable x204 = Variable.unary("ValidChoices_p");
		Decls x203 = x204.oneOf(x6);
		Decls x200 = x201.and(x203);
		Expression x210 = x202.join(x10);
		Expression x209 = x210.join(x6);
		Expression x208 = x209.join(x6);
		Expression x215 = x202.join(x10);
		Expression x214 = x215.join(x6);
		Expression x213 = x214.join(x6);
		Expression x218 = x12.transpose();
		Expression x217 = x218.closure();
		Expression x216 = x213.join(x217);
		Expression x212 = x213.difference(x216);
		Expression x211 = x212.join(x12);
		Expression x207 = x208.union(x211);
		Formula x206 = x204.in(x207);
		Expression x224 = x202.join(x10);
		Expression x223 = x224.join(x6);
		Expression x222 = x223.join(x6);
		Formula x221 = x204.in(x222);
		Formula x220 = x221.not();
		Expression x230 = x202.join(x10);
		Expression x229 = x204.join(x230);
		Expression x228 = x9.join(x229);
		Formula x227 = x228.some();
		Formula x226 = x227.not();
		Expression x237 = x202.join(x10);
		Expression x236 = x237.join(x6);
		Expression x235 = x236.join(x6);
		Formula x234 = x204.in(x235);
		Formula x233 = x234.not();
		Formula x232 = x233.not();
		Expression x241 = x202.join(x10);
		Expression x240 = x204.join(x241);
		Expression x239 = x12.join(x240);
		Expression x243 = x228.join(x184);
		Expression x244 = x228.join(x10);
		Expression x242 = x243.join(x244);
		Formula x238 = x239.eq(x242);
		Formula x231 = x232.and(x238);
		Formula x225 = x226.or(x231);
		Formula x219 = x220.or(x225);
		Formula x205 = x206.and(x219);
		Expression x199 = x205.comprehension(x200);
		Expression x198 = x193.join(x199);
		Formula x197 = x195.in(x198);
		Variable x247 = Variable.unary("ValidBest_j");
		Expression x248 = x193.join(x199);
		Decls x246 = x247.oneOf(x248);
		Expression x253 = x12.transpose();
		Expression x252 = x253.closure();
		Expression x251 = x195.join(x252);
		Formula x250 = x247.in(x251);
		Formula x249 = x250.not();
		Formula x245 = x249.forAll(x246);
		Formula x196 = x197.and(x245);
		Expression x190 = x196.comprehension(x191);
		Formula x183 = x184.eq(x190);
		Formula x169 = x170.and(x183);
		Formula x155 = x156.and(x169);
		Expression x258 = x189.join(x10);
		Expression x257 = x258.join(x6);
		Expression x256 = x257.join(x6);
		Expression x263 = x189.join(x10);
		Expression x262 = x263.join(x6);
		Expression x261 = x262.join(x6);
		Expression x266 = x12.transpose();
		Expression x265 = x266.closure();
		Expression x264 = x261.join(x265);
		Expression x260 = x261.difference(x264);
		Expression x259 = x260.join(x12);
		Expression x255 = x256.union(x259);
		Formula x254 = x153.in(x255);
		Formula x154 = x155.and(x254);
		Expression x146 = x154.comprehension(x147);
		Formula x145 = x146.one();
		Variable x272 = Variable.unary("DW3NE_p1");
		Expression x276 = x8.join(x10);
		Expression x275 = x276.join(x6);
		Expression x274 = x275.join(x6);
		Expression x281 = x8.join(x10);
		Expression x280 = x281.join(x6);
		Expression x279 = x280.join(x6);
		Expression x284 = x12.transpose();
		Expression x283 = x284.closure();
		Expression x282 = x279.join(x283);
		Expression x278 = x279.difference(x282);
		Expression x277 = x278.join(x12);
		Expression x273 = x274.union(x277);
		Decls x271 = x272.oneOf(x273);
		Variable x286 = Variable.unary("DW3NE_p2");
		Expression x290 = x9.join(x10);
		Expression x289 = x290.join(x6);
		Expression x288 = x289.join(x6);
		Expression x295 = x9.join(x10);
		Expression x294 = x295.join(x6);
		Expression x293 = x294.join(x6);
		Expression x298 = x12.transpose();
		Expression x297 = x298.closure();
		Expression x296 = x293.join(x297);
		Expression x292 = x293.difference(x296);
		Expression x291 = x292.join(x12);
		Expression x287 = x288.union(x291);
		Decls x285 = x286.oneOf(x287);
		Variable x300 = Variable.unary("DW3NE_p3");
		Expression x305 = x9.join(x12);
		Expression x304 = x305.join(x10);
		Expression x303 = x304.join(x6);
		Expression x302 = x303.join(x6);
		Expression x310 = x305.join(x10);
		Expression x309 = x310.join(x6);
		Expression x308 = x309.join(x6);
		Expression x313 = x12.transpose();
		Expression x312 = x313.closure();
		Expression x311 = x308.join(x312);
		Expression x307 = x308.difference(x311);
		Expression x306 = x307.join(x12);
		Expression x301 = x302.union(x306);
		Decls x299 = x300.oneOf(x301);
		Decls x270 = x271.and(x285).and(x299);
		Variable x316 = Variable.unary("DW3NE_p1h");
		Variable x319 = Variable.unary("DW3NE_i");
		Decls x318 = x319.oneOf(x6);
		Expression x323 = x12.transpose();
		Expression x322 = x323.closure();
		Expression x321 = x272.join(x322);
		Formula x320 = x319.in(x321);
		Expression x317 = x320.comprehension(x318);
		Decls x315 = x316.oneOf(x317);
		Variable x326 = Variable.unary("DW3NE_p2h");
		Variable x329 = Variable.unary("DW3NE_i");
		Decls x328 = x329.oneOf(x6);
		Expression x333 = x12.transpose();
		Expression x332 = x333.closure();
		Expression x331 = x286.join(x332);
		Formula x330 = x329.in(x331);
		Expression x327 = x330.comprehension(x328);
		Decls x325 = x326.oneOf(x327);
		Variable x336 = Variable.unary("DW3NE_p3h");
		Variable x339 = Variable.unary("DW3NE_i");
		Decls x338 = x339.oneOf(x6);
		Expression x343 = x12.transpose();
		Expression x342 = x343.closure();
		Expression x341 = x300.join(x342);
		Formula x340 = x339.in(x341);
		Expression x337 = x340.comprehension(x338);
		Decls x335 = x336.oneOf(x337);
		Variable x347 = Variable.unary("DW3NE_pa2h");
		Expression x349 = x9.union(x8);
		Expression x350 = x9.join(x12);
		Expression x348 = x349.union(x350);
		Decls x346 = x347.oneOf(x348);
		Variable x352 = Variable.unary("DW3NE_pa3h");
		Decls x351 = x352.oneOf(x348);
		Decls x345 = x346.and(x351);
		Variable x355 = Variable.unary("DW3NE_pa2l");
		Expression x358 = x9.union(x8);
		Expression x359 = x9.join(x12);
		Expression x357 = x358.union(x359);
		Expression x356 = x357.difference(x347);
		Decls x354 = x355.oneOf(x356);
		Variable x362 = Variable.unary("DW3NE_pa3l");
		Expression x365 = x9.union(x8);
		Expression x366 = x9.join(x12);
		Expression x364 = x365.union(x366);
		Expression x363 = x364.difference(x352);
		Decls x361 = x362.oneOf(x363);
		Variable x373 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x379 = x8.join(x10);
		Expression x378 = x316.join(x379);
		Expression x377 = x9.join(x378);
		Expression x376 = x377.join(x10);
		Expression x375 = x376.join(x6);
		Expression x374 = x375.join(x6);
		Decls x372 = x373.oneOf(x374);
		Expression x384 = x8.join(x10);
		Expression x383 = x316.join(x384);
		Expression x382 = x12.join(x383);
		Expression x386 = x377.join(x10);
		Expression x385 = x373.join(x386);
		Formula x381 = x382.eq(x385);
		Expression x396 = x272.product(x9);
		Expression x395 = x8.product(x396);
		Expression x398 = x316.product(x8);
		Expression x397 = x8.product(x398);
		Expression x394 = x395.union(x397);
		Expression x400 = x286.product(x355);
		Expression x399 = x9.product(x400);
		Expression x393 = x394.union(x399);
		Expression x402 = x326.product(x347);
		Expression x401 = x9.product(x402);
		Expression x392 = x393.union(x401);
		Expression x404 = x300.product(x362);
		Expression x403 = x305.product(x404);
		Expression x391 = x392.union(x403);
		Expression x406 = x336.product(x352);
		Expression x405 = x305.product(x406);
		Expression x390 = x391.union(x405);
		Expression x389 = x8.join(x390);
		Expression x388 = x316.join(x389);
		Expression x408 = x377.join(x390);
		Expression x407 = x373.join(x408);
		Formula x387 = x388.eq(x407);
		Formula x380 = x381.and(x387);
		Formula x371 = x380.forSome(x372);
		Expression x415 = x8.join(x10);
		Expression x414 = x415.join(x6);
		Expression x413 = x414.join(x6);
		Formula x412 = x272.in(x413);
		Formula x411 = x412.not();
		Expression x419 = x8.join(x10);
		Expression x418 = x272.join(x419);
		Expression x417 = x9.join(x418);
		Formula x416 = x417.no();
		Formula x410 = x411.or(x416);
		Variable x422 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x428 = x8.join(x10);
		Expression x427 = x272.join(x428);
		Expression x426 = x9.join(x427);
		Expression x425 = x426.join(x10);
		Expression x424 = x425.join(x6);
		Expression x423 = x424.join(x6);
		Decls x421 = x422.oneOf(x423);
		Expression x433 = x8.join(x10);
		Expression x432 = x272.join(x433);
		Expression x431 = x12.join(x432);
		Expression x435 = x426.join(x10);
		Expression x434 = x422.join(x435);
		Formula x430 = x431.eq(x434);
		Expression x438 = x8.join(x390);
		Expression x437 = x272.join(x438);
		Expression x440 = x426.join(x390);
		Expression x439 = x422.join(x440);
		Formula x436 = x437.eq(x439);
		Formula x429 = x430.and(x436);
		Formula x420 = x429.forSome(x421);
		Formula x409 = x410.or(x420);
		Formula x370 = x371.and(x409);
		Variable x443 = Variable.unary("DWNodeCheckNE_k");
		Variable x446 = Variable.unary("DWNodeCheckNE_i");
		Decls x445 = x446.oneOf(x6);
		Expression x451 = x12.transpose();
		Expression x450 = x451.closure();
		Expression x449 = x272.join(x450);
		Formula x448 = x446.in(x449);
		Formula x453 = x446.eq(x316);
		Formula x452 = x453.not();
		Formula x447 = x448.and(x452);
		Expression x444 = x447.comprehension(x445);
		Decls x442 = x443.oneOf(x444);
		Expression x459 = x8.join(x10);
		Expression x458 = x443.join(x459);
		Expression x457 = x9.join(x458);
		Formula x456 = x457.no();
		Formula x455 = x456.not();
		Variable x462 = Variable.unary("DWNodeCheckNE_first_hop_k_pref");
		Expression x466 = x8.join(x10);
		Expression x465 = x443.join(x466);
		Expression x464 = x9.join(x465);
		Expression x472 = x8.product(x272);
		Expression x473 = x8.product(x316);
		Expression x471 = x472.union(x473);
		Expression x474 = x9.product(x286);
		Expression x470 = x471.union(x474);
		Expression x475 = x9.product(x326);
		Expression x469 = x470.union(x475);
		Expression x476 = x305.product(x300);
		Expression x468 = x469.union(x476);
		Expression x477 = x305.product(x336);
		Expression x467 = x468.union(x477);
		Expression x463 = x464.join(x467);
		Decls x461 = x462.oneOf(x463);
		Expression x486 = x8.join(x10);
		Expression x485 = x486.join(x6);
		Expression x484 = x485.join(x6);
		Formula x483 = x443.in(x484);
		Formula x482 = x483.not();
		Formula x481 = x482.not();
		Expression x490 = x8.join(x10);
		Expression x489 = x443.join(x490);
		Expression x488 = x12.join(x489);
		Expression x492 = x464.join(x10);
		Expression x491 = x462.join(x492);
		Formula x487 = x488.eq(x491);
		Formula x480 = x481.and(x487);
		Formula x479 = x480.not();
		Expression x496 = x464.join(x390);
		Expression x495 = x462.join(x496);
		Expression x498 = x8.join(x390);
		Expression x497 = x316.join(x498);
		Formula x494 = x495.eq(x497);
		Expression x501 = x12.closure();
		Expression x500 = x316.join(x501);
		Formula x499 = x443.in(x500);
		Formula x493 = x494.and(x499);
		Formula x478 = x479.or(x493);
		Formula x460 = x478.forAll(x461);
		Formula x454 = x455.and(x460);
		Formula x441 = x454.forAll(x442);
		Formula x369 = x370.and(x441);
		Variable x506 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x512 = x9.join(x10);
		Expression x511 = x326.join(x512);
		Expression x510 = x9.join(x511);
		Expression x509 = x510.join(x10);
		Expression x508 = x509.join(x6);
		Expression x507 = x508.join(x6);
		Decls x505 = x506.oneOf(x507);
		Expression x517 = x9.join(x10);
		Expression x516 = x326.join(x517);
		Expression x515 = x12.join(x516);
		Expression x519 = x510.join(x10);
		Expression x518 = x506.join(x519);
		Formula x514 = x515.eq(x518);
		Expression x522 = x9.join(x390);
		Expression x521 = x326.join(x522);
		Expression x524 = x510.join(x390);
		Expression x523 = x506.join(x524);
		Formula x520 = x521.eq(x523);
		Formula x513 = x514.and(x520);
		Formula x504 = x513.forSome(x505);
		Expression x531 = x9.join(x10);
		Expression x530 = x531.join(x6);
		Expression x529 = x530.join(x6);
		Formula x528 = x286.in(x529);
		Formula x527 = x528.not();
		Expression x535 = x9.join(x10);
		Expression x534 = x286.join(x535);
		Expression x533 = x9.join(x534);
		Formula x532 = x533.no();
		Formula x526 = x527.or(x532);
		Variable x538 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x544 = x9.join(x10);
		Expression x543 = x286.join(x544);
		Expression x542 = x9.join(x543);
		Expression x541 = x542.join(x10);
		Expression x540 = x541.join(x6);
		Expression x539 = x540.join(x6);
		Decls x537 = x538.oneOf(x539);
		Expression x549 = x9.join(x10);
		Expression x548 = x286.join(x549);
		Expression x547 = x12.join(x548);
		Expression x551 = x542.join(x10);
		Expression x550 = x538.join(x551);
		Formula x546 = x547.eq(x550);
		Expression x554 = x9.join(x390);
		Expression x553 = x286.join(x554);
		Expression x556 = x542.join(x390);
		Expression x555 = x538.join(x556);
		Formula x552 = x553.eq(x555);
		Formula x545 = x546.and(x552);
		Formula x536 = x545.forSome(x537);
		Formula x525 = x526.or(x536);
		Formula x503 = x504.and(x525);
		Variable x559 = Variable.unary("DWNodeCheckNE_k");
		Variable x562 = Variable.unary("DWNodeCheckNE_i");
		Decls x561 = x562.oneOf(x6);
		Expression x567 = x12.transpose();
		Expression x566 = x567.closure();
		Expression x565 = x286.join(x566);
		Formula x564 = x562.in(x565);
		Formula x569 = x562.eq(x326);
		Formula x568 = x569.not();
		Formula x563 = x564.and(x568);
		Expression x560 = x563.comprehension(x561);
		Decls x558 = x559.oneOf(x560);
		Expression x575 = x9.join(x10);
		Expression x574 = x559.join(x575);
		Expression x573 = x9.join(x574);
		Formula x572 = x573.no();
		Formula x571 = x572.not();
		Variable x578 = Variable.unary("DWNodeCheckNE_first_hop_k_pref");
		Expression x582 = x9.join(x10);
		Expression x581 = x559.join(x582);
		Expression x580 = x9.join(x581);
		Expression x579 = x580.join(x467);
		Decls x577 = x578.oneOf(x579);
		Expression x591 = x9.join(x10);
		Expression x590 = x591.join(x6);
		Expression x589 = x590.join(x6);
		Formula x588 = x559.in(x589);
		Formula x587 = x588.not();
		Formula x586 = x587.not();
		Expression x595 = x9.join(x10);
		Expression x594 = x559.join(x595);
		Expression x593 = x12.join(x594);
		Expression x597 = x580.join(x10);
		Expression x596 = x578.join(x597);
		Formula x592 = x593.eq(x596);
		Formula x585 = x586.and(x592);
		Formula x584 = x585.not();
		Expression x601 = x580.join(x390);
		Expression x600 = x578.join(x601);
		Expression x603 = x9.join(x390);
		Expression x602 = x326.join(x603);
		Formula x599 = x600.eq(x602);
		Expression x606 = x12.closure();
		Expression x605 = x326.join(x606);
		Formula x604 = x559.in(x605);
		Formula x598 = x599.and(x604);
		Formula x583 = x584.or(x598);
		Formula x576 = x583.forAll(x577);
		Formula x570 = x571.and(x576);
		Formula x557 = x570.forAll(x558);
		Formula x502 = x503.and(x557);
		Formula x368 = x369.and(x502);
		Variable x611 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x617 = x305.join(x10);
		Expression x616 = x336.join(x617);
		Expression x615 = x9.join(x616);
		Expression x614 = x615.join(x10);
		Expression x613 = x614.join(x6);
		Expression x612 = x613.join(x6);
		Decls x610 = x611.oneOf(x612);
		Expression x622 = x305.join(x10);
		Expression x621 = x336.join(x622);
		Expression x620 = x12.join(x621);
		Expression x624 = x615.join(x10);
		Expression x623 = x611.join(x624);
		Formula x619 = x620.eq(x623);
		Expression x627 = x305.join(x390);
		Expression x626 = x336.join(x627);
		Expression x629 = x615.join(x390);
		Expression x628 = x611.join(x629);
		Formula x625 = x626.eq(x628);
		Formula x618 = x619.and(x625);
		Formula x609 = x618.forSome(x610);
		Expression x636 = x305.join(x10);
		Expression x635 = x636.join(x6);
		Expression x634 = x635.join(x6);
		Formula x633 = x300.in(x634);
		Formula x632 = x633.not();
		Expression x640 = x305.join(x10);
		Expression x639 = x300.join(x640);
		Expression x638 = x9.join(x639);
		Formula x637 = x638.no();
		Formula x631 = x632.or(x637);
		Variable x643 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x649 = x305.join(x10);
		Expression x648 = x300.join(x649);
		Expression x647 = x9.join(x648);
		Expression x646 = x647.join(x10);
		Expression x645 = x646.join(x6);
		Expression x644 = x645.join(x6);
		Decls x642 = x643.oneOf(x644);
		Expression x654 = x305.join(x10);
		Expression x653 = x300.join(x654);
		Expression x652 = x12.join(x653);
		Expression x656 = x647.join(x10);
		Expression x655 = x643.join(x656);
		Formula x651 = x652.eq(x655);
		Expression x659 = x305.join(x390);
		Expression x658 = x300.join(x659);
		Expression x661 = x647.join(x390);
		Expression x660 = x643.join(x661);
		Formula x657 = x658.eq(x660);
		Formula x650 = x651.and(x657);
		Formula x641 = x650.forSome(x642);
		Formula x630 = x631.or(x641);
		Formula x608 = x609.and(x630);
		Variable x664 = Variable.unary("DWNodeCheckNE_k");
		Variable x667 = Variable.unary("DWNodeCheckNE_i");
		Decls x666 = x667.oneOf(x6);
		Expression x672 = x12.transpose();
		Expression x671 = x672.closure();
		Expression x670 = x300.join(x671);
		Formula x669 = x667.in(x670);
		Formula x674 = x667.eq(x336);
		Formula x673 = x674.not();
		Formula x668 = x669.and(x673);
		Expression x665 = x668.comprehension(x666);
		Decls x663 = x664.oneOf(x665);
		Expression x680 = x305.join(x10);
		Expression x679 = x664.join(x680);
		Expression x678 = x9.join(x679);
		Formula x677 = x678.no();
		Formula x676 = x677.not();
		Variable x683 = Variable.unary("DWNodeCheckNE_first_hop_k_pref");
		Expression x687 = x305.join(x10);
		Expression x686 = x664.join(x687);
		Expression x685 = x9.join(x686);
		Expression x684 = x685.join(x467);
		Decls x682 = x683.oneOf(x684);
		Expression x696 = x305.join(x10);
		Expression x695 = x696.join(x6);
		Expression x694 = x695.join(x6);
		Formula x693 = x664.in(x694);
		Formula x692 = x693.not();
		Formula x691 = x692.not();
		Expression x700 = x305.join(x10);
		Expression x699 = x664.join(x700);
		Expression x698 = x12.join(x699);
		Expression x702 = x685.join(x10);
		Expression x701 = x683.join(x702);
		Formula x697 = x698.eq(x701);
		Formula x690 = x691.and(x697);
		Formula x689 = x690.not();
		Expression x706 = x685.join(x390);
		Expression x705 = x683.join(x706);
		Expression x708 = x305.join(x390);
		Expression x707 = x336.join(x708);
		Formula x704 = x705.eq(x707);
		Expression x711 = x12.closure();
		Expression x710 = x336.join(x711);
		Formula x709 = x664.in(x710);
		Formula x703 = x704.and(x709);
		Formula x688 = x689.or(x703);
		Formula x681 = x688.forAll(x682);
		Formula x675 = x676.and(x681);
		Formula x662 = x675.forAll(x663);
		Formula x607 = x608.and(x662);
		Formula x367 = x368.and(x607);
		Formula x360 = x367.forSome(x361);
		Formula x353 = x360.forSome(x354);
		Formula x344 = x353.forSome(x345);
		Formula x334 = x344.forSome(x335);
		Formula x324 = x334.forSome(x325);
		Formula x314 = x324.forSome(x315);
		Formula x269 = x314.forSome(x270);
		Variable x714 = Variable.unary("checkOneSolvable3ToNinjaWheel_n1");
		Expression x716 = x8.union(x9);
		Expression x717 = x9.join(x12);
		Expression x715 = x716.union(x717);
		Decls x713 = x714.oneOf(x715);
		Variable x720 = Variable.unary("checkOneSolvable3ToNinjaWheel_n2");
		Expression x723 = x8.union(x9);
		Expression x724 = x9.join(x12);
		Expression x722 = x723.union(x724);
		Expression x721 = x722.difference(x714);
		Decls x719 = x720.oneOf(x721);
		Variable x727 = Variable.unary("checkOneSolvable3ToNinjaWheel_n3");
		Expression x730 = x8.union(x9);
		Expression x731 = x9.join(x12);
		Expression x729 = x730.union(x731);
		Expression x732 = x714.union(x720);
		Expression x728 = x729.difference(x732);
		Decls x726 = x727.oneOf(x728);
		Variable x735 = Variable.unary("DW2E1_p1");
		Expression x739 = x714.join(x10);
		Expression x738 = x739.join(x6);
		Expression x737 = x738.join(x6);
		Expression x744 = x714.join(x10);
		Expression x743 = x744.join(x6);
		Expression x742 = x743.join(x6);
		Expression x747 = x12.transpose();
		Expression x746 = x747.closure();
		Expression x745 = x742.join(x746);
		Expression x741 = x742.difference(x745);
		Expression x740 = x741.join(x12);
		Expression x736 = x737.union(x740);
		Decls x734 = x735.oneOf(x736);
		Variable x750 = Variable.unary("DW2E1_p1h");
		Variable x753 = Variable.unary("DW2E1_i");
		Decls x752 = x753.oneOf(x6);
		Expression x757 = x12.transpose();
		Expression x756 = x757.closure();
		Expression x755 = x735.join(x756);
		Formula x754 = x753.in(x755);
		Expression x751 = x754.comprehension(x752);
		Decls x749 = x750.oneOf(x751);
		Variable x760 = Variable.unary("DW2E1_p2");
		Expression x764 = x720.join(x10);
		Expression x763 = x764.join(x6);
		Expression x762 = x763.join(x6);
		Expression x769 = x720.join(x10);
		Expression x768 = x769.join(x6);
		Expression x767 = x768.join(x6);
		Expression x772 = x12.transpose();
		Expression x771 = x772.closure();
		Expression x770 = x767.join(x771);
		Expression x766 = x767.difference(x770);
		Expression x765 = x766.join(x12);
		Expression x761 = x762.union(x765);
		Decls x759 = x760.oneOf(x761);
		Variable x775 = Variable.unary("DW2E1_p2h");
		Variable x778 = Variable.unary("DW2E1_i");
		Decls x777 = x778.oneOf(x6);
		Expression x782 = x12.transpose();
		Expression x781 = x782.closure();
		Expression x780 = x760.join(x781);
		Formula x779 = x778.in(x780);
		Expression x776 = x779.comprehension(x777);
		Decls x774 = x775.oneOf(x776);
		Variable x785 = Variable.unary("DW2E1_p3");
		Expression x789 = x727.join(x10);
		Expression x788 = x789.join(x6);
		Expression x787 = x788.join(x6);
		Expression x794 = x727.join(x10);
		Expression x793 = x794.join(x6);
		Expression x792 = x793.join(x6);
		Expression x797 = x12.transpose();
		Expression x796 = x797.closure();
		Expression x795 = x792.join(x796);
		Expression x791 = x792.difference(x795);
		Expression x790 = x791.join(x12);
		Expression x786 = x787.union(x790);
		Decls x784 = x785.oneOf(x786);
		Variable x800 = Variable.unary("DW2E1_pa2h");
		Expression x802 = x9.union(x8);
		Expression x803 = x9.join(x12);
		Expression x801 = x802.union(x803);
		Decls x799 = x800.oneOf(x801);
		Variable x806 = Variable.unary("DW2E1_pa2l");
		Expression x809 = x9.union(x8);
		Expression x810 = x9.join(x12);
		Expression x808 = x809.union(x810);
		Expression x807 = x808.difference(x800);
		Decls x805 = x806.oneOf(x807);
		Expression x814 = x727.product(x785);
		Variable x818 = Variable.unary("ValidBest_node");
		Decls x817 = x818.oneOf(x6);
		Variable x820 = Variable.unary("ValidBest_pref");
		Decls x819 = x820.oneOf(x6);
		Decls x816 = x817.and(x819);
		Variable x827 = Variable.unary("ValidChoices2_n");
		Decls x826 = x827.oneOf(x6);
		Variable x829 = Variable.unary("ValidChoices2_p");
		Decls x828 = x829.oneOf(x6);
		Decls x825 = x826.and(x828);
		Expression x835 = x827.join(x10);
		Expression x834 = x835.join(x6);
		Expression x833 = x834.join(x6);
		Expression x840 = x827.join(x10);
		Expression x839 = x840.join(x6);
		Expression x838 = x839.join(x6);
		Expression x843 = x12.transpose();
		Expression x842 = x843.closure();
		Expression x841 = x838.join(x842);
		Expression x837 = x838.difference(x841);
		Expression x836 = x837.join(x12);
		Expression x832 = x833.union(x836);
		Formula x831 = x829.in(x832);
		Expression x849 = x827.join(x10);
		Expression x848 = x849.join(x6);
		Expression x847 = x848.join(x6);
		Formula x846 = x829.in(x847);
		Formula x845 = x846.not();
		Expression x855 = x827.join(x10);
		Expression x854 = x829.join(x855);
		Expression x853 = x9.join(x854);
		Formula x852 = x853.some();
		Formula x851 = x852.not();
		Variable x858 = Variable.unary("ValidPathChoice2_p");
		Expression x863 = x714.product(x735);
		Expression x864 = x720.product(x760);
		Expression x862 = x863.union(x864);
		Expression x866 = x714.product(x750);
		Expression x867 = x720.product(x775);
		Expression x865 = x866.union(x867);
		Expression x861 = x862.union(x865);
		Expression x860 = x814.union(x861);
		Expression x859 = x853.join(x860);
		Decls x857 = x858.oneOf(x859);
		Expression x874 = x827.join(x10);
		Expression x873 = x874.join(x6);
		Expression x872 = x873.join(x6);
		Formula x871 = x829.in(x872);
		Formula x870 = x871.not();
		Formula x869 = x870.not();
		Expression x878 = x827.join(x10);
		Expression x877 = x829.join(x878);
		Expression x876 = x12.join(x877);
		Expression x880 = x853.join(x10);
		Expression x879 = x858.join(x880);
		Formula x875 = x876.eq(x879);
		Formula x868 = x869.and(x875);
		Formula x856 = x868.forSome(x857);
		Formula x850 = x851.or(x856);
		Formula x844 = x845.or(x850);
		Formula x830 = x831.and(x844);
		Expression x824 = x830.comprehension(x825);
		Expression x823 = x818.join(x824);
		Formula x822 = x820.in(x823);
		Variable x883 = Variable.unary("ValidBest_j");
		Expression x884 = x818.join(x824);
		Decls x882 = x883.oneOf(x884);
		Expression x889 = x12.transpose();
		Expression x888 = x889.closure();
		Expression x887 = x820.join(x888);
		Formula x886 = x883.in(x887);
		Formula x885 = x886.not();
		Formula x881 = x885.forAll(x882);
		Formula x821 = x822.and(x881);
		Expression x815 = x821.comprehension(x816);
		Formula x813 = x814.in(x815);
		Variable x893 = Variable.unary("DW2E_n");
		Decls x892 = x893.oneOf(x727);
		Expression x898 = x893.join(x814);
		Expression x899 = x893.join(x10);
		Expression x897 = x898.join(x899);
		Expression x896 = x6.join(x897);
		Expression x900 = x44.difference(x727);
		Expression x895 = x896.intersection(x900);
		Formula x894 = x895.no();
		Formula x891 = x894.forAll(x892);
		Variable x905 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x911 = x720.join(x10);
		Expression x910 = x775.join(x911);
		Expression x909 = x9.join(x910);
		Expression x908 = x909.join(x10);
		Expression x907 = x908.join(x6);
		Expression x906 = x907.join(x6);
		Decls x904 = x905.oneOf(x906);
		Expression x916 = x720.join(x10);
		Expression x915 = x775.join(x916);
		Expression x914 = x12.join(x915);
		Expression x918 = x909.join(x10);
		Expression x917 = x905.join(x918);
		Formula x913 = x914.eq(x917);
		Expression x925 = x735.product(x9);
		Expression x924 = x714.product(x925);
		Expression x927 = x760.product(x806);
		Expression x926 = x720.product(x927);
		Expression x923 = x924.union(x926);
		Expression x930 = x750.product(x8);
		Expression x929 = x714.product(x930);
		Expression x932 = x775.product(x800);
		Expression x931 = x720.product(x932);
		Expression x928 = x929.union(x931);
		Expression x922 = x923.union(x928);
		Expression x921 = x720.join(x922);
		Expression x920 = x775.join(x921);
		Expression x934 = x909.join(x922);
		Expression x933 = x905.join(x934);
		Formula x919 = x920.eq(x933);
		Formula x912 = x913.and(x919);
		Formula x903 = x912.forSome(x904);
		Expression x941 = x720.join(x10);
		Expression x940 = x941.join(x6);
		Expression x939 = x940.join(x6);
		Formula x938 = x760.in(x939);
		Formula x937 = x938.not();
		Expression x946 = x720.join(x10);
		Expression x945 = x760.join(x946);
		Expression x944 = x9.join(x945);
		Formula x943 = x944.no();
		Variable x949 = Variable.unary("isLeg_pref2");
		Expression x950 = x944.join(x814);
		Decls x948 = x949.oneOf(x950);
		Expression x957 = x720.join(x10);
		Expression x956 = x957.join(x6);
		Expression x955 = x956.join(x6);
		Formula x954 = x760.in(x955);
		Formula x953 = x954.not();
		Formula x952 = x953.not();
		Expression x961 = x720.join(x10);
		Expression x960 = x760.join(x961);
		Expression x959 = x12.join(x960);
		Expression x963 = x944.join(x10);
		Expression x962 = x949.join(x963);
		Formula x958 = x959.eq(x962);
		Formula x951 = x952.and(x958);
		Formula x947 = x951.forSome(x948);
		Formula x942 = x943.or(x947);
		Formula x936 = x937.or(x942);
		Variable x966 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x972 = x720.join(x10);
		Expression x971 = x760.join(x972);
		Expression x970 = x9.join(x971);
		Expression x969 = x970.join(x10);
		Expression x968 = x969.join(x6);
		Expression x967 = x968.join(x6);
		Decls x965 = x966.oneOf(x967);
		Expression x977 = x720.join(x10);
		Expression x976 = x760.join(x977);
		Expression x975 = x12.join(x976);
		Expression x979 = x970.join(x10);
		Expression x978 = x966.join(x979);
		Formula x974 = x975.eq(x978);
		Expression x982 = x720.join(x922);
		Expression x981 = x760.join(x982);
		Expression x984 = x970.join(x922);
		Expression x983 = x966.join(x984);
		Formula x980 = x981.eq(x983);
		Formula x973 = x974.and(x980);
		Formula x964 = x973.forSome(x965);
		Formula x935 = x936.or(x964);
		Formula x902 = x903.and(x935);
		Variable x987 = Variable.unary("DWNodeCheck_k");
		Variable x990 = Variable.unary("DWNodeCheck_i");
		Decls x989 = x990.oneOf(x6);
		Expression x995 = x12.transpose();
		Expression x994 = x995.closure();
		Expression x993 = x760.join(x994);
		Formula x992 = x990.in(x993);
		Formula x997 = x990.eq(x775);
		Formula x996 = x997.not();
		Formula x991 = x992.and(x996);
		Expression x988 = x991.comprehension(x989);
		Decls x986 = x987.oneOf(x988);
		Expression x1004 = x720.join(x10);
		Expression x1003 = x987.join(x1004);
		Expression x1002 = x9.join(x1003);
		Formula x1001 = x1002.no();
		Variable x1007 = Variable.unary("isLeg_pref2");
		Expression x1008 = x1002.join(x814);
		Decls x1006 = x1007.oneOf(x1008);
		Expression x1015 = x720.join(x10);
		Expression x1014 = x1015.join(x6);
		Expression x1013 = x1014.join(x6);
		Formula x1012 = x987.in(x1013);
		Formula x1011 = x1012.not();
		Formula x1010 = x1011.not();
		Expression x1019 = x720.join(x10);
		Expression x1018 = x987.join(x1019);
		Expression x1017 = x12.join(x1018);
		Expression x1021 = x1002.join(x10);
		Expression x1020 = x1007.join(x1021);
		Formula x1016 = x1017.eq(x1020);
		Formula x1009 = x1010.and(x1016);
		Formula x1005 = x1009.forSome(x1006);
		Formula x1000 = x1001.or(x1005);
		Formula x999 = x1000.not();
		Variable x1024 = Variable.unary("DWNodeCheck_first_hop_k_pref");
		Expression x1028 = x720.join(x10);
		Expression x1027 = x987.join(x1028);
		Expression x1026 = x9.join(x1027);
		Expression x1025 = x1026.join(x861);
		Decls x1023 = x1024.oneOf(x1025);
		Expression x1037 = x720.join(x10);
		Expression x1036 = x1037.join(x6);
		Expression x1035 = x1036.join(x6);
		Formula x1034 = x987.in(x1035);
		Formula x1033 = x1034.not();
		Formula x1032 = x1033.not();
		Expression x1041 = x720.join(x10);
		Expression x1040 = x987.join(x1041);
		Expression x1039 = x12.join(x1040);
		Expression x1043 = x1026.join(x10);
		Expression x1042 = x1024.join(x1043);
		Formula x1038 = x1039.eq(x1042);
		Formula x1031 = x1032.and(x1038);
		Formula x1030 = x1031.not();
		Expression x1047 = x1026.join(x922);
		Expression x1046 = x1024.join(x1047);
		Expression x1049 = x720.join(x922);
		Expression x1048 = x775.join(x1049);
		Formula x1045 = x1046.eq(x1048);
		Expression x1052 = x12.closure();
		Expression x1051 = x775.join(x1052);
		Formula x1050 = x987.in(x1051);
		Formula x1044 = x1045.and(x1050);
		Formula x1029 = x1030.or(x1044);
		Formula x1022 = x1029.forAll(x1023);
		Formula x998 = x999.and(x1022);
		Formula x985 = x998.forAll(x986);
		Formula x901 = x902.and(x985);
		Formula x890 = x891.and(x901);
		Formula x812 = x813.and(x890);
		Variable x1057 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x1063 = x714.join(x10);
		Expression x1062 = x750.join(x1063);
		Expression x1061 = x9.join(x1062);
		Expression x1060 = x1061.join(x10);
		Expression x1059 = x1060.join(x6);
		Expression x1058 = x1059.join(x6);
		Decls x1056 = x1057.oneOf(x1058);
		Expression x1068 = x714.join(x10);
		Expression x1067 = x750.join(x1068);
		Expression x1066 = x12.join(x1067);
		Expression x1070 = x1061.join(x10);
		Expression x1069 = x1057.join(x1070);
		Formula x1065 = x1066.eq(x1069);
		Expression x1073 = x714.join(x922);
		Expression x1072 = x750.join(x1073);
		Expression x1075 = x1061.join(x922);
		Expression x1074 = x1057.join(x1075);
		Formula x1071 = x1072.eq(x1074);
		Formula x1064 = x1065.and(x1071);
		Formula x1055 = x1064.forSome(x1056);
		Expression x1082 = x714.join(x10);
		Expression x1081 = x1082.join(x6);
		Expression x1080 = x1081.join(x6);
		Formula x1079 = x735.in(x1080);
		Formula x1078 = x1079.not();
		Expression x1087 = x714.join(x10);
		Expression x1086 = x735.join(x1087);
		Expression x1085 = x9.join(x1086);
		Formula x1084 = x1085.no();
		Variable x1090 = Variable.unary("isLeg_pref2");
		Expression x1091 = x1085.join(x814);
		Decls x1089 = x1090.oneOf(x1091);
		Expression x1098 = x714.join(x10);
		Expression x1097 = x1098.join(x6);
		Expression x1096 = x1097.join(x6);
		Formula x1095 = x735.in(x1096);
		Formula x1094 = x1095.not();
		Formula x1093 = x1094.not();
		Expression x1102 = x714.join(x10);
		Expression x1101 = x735.join(x1102);
		Expression x1100 = x12.join(x1101);
		Expression x1104 = x1085.join(x10);
		Expression x1103 = x1090.join(x1104);
		Formula x1099 = x1100.eq(x1103);
		Formula x1092 = x1093.and(x1099);
		Formula x1088 = x1092.forSome(x1089);
		Formula x1083 = x1084.or(x1088);
		Formula x1077 = x1078.or(x1083);
		Variable x1107 = Variable.unary("goesThruItsOwnParity_pref2");
		Expression x1113 = x714.join(x10);
		Expression x1112 = x735.join(x1113);
		Expression x1111 = x9.join(x1112);
		Expression x1110 = x1111.join(x10);
		Expression x1109 = x1110.join(x6);
		Expression x1108 = x1109.join(x6);
		Decls x1106 = x1107.oneOf(x1108);
		Expression x1118 = x714.join(x10);
		Expression x1117 = x735.join(x1118);
		Expression x1116 = x12.join(x1117);
		Expression x1120 = x1111.join(x10);
		Expression x1119 = x1107.join(x1120);
		Formula x1115 = x1116.eq(x1119);
		Expression x1123 = x714.join(x922);
		Expression x1122 = x735.join(x1123);
		Expression x1125 = x1111.join(x922);
		Expression x1124 = x1107.join(x1125);
		Formula x1121 = x1122.eq(x1124);
		Formula x1114 = x1115.and(x1121);
		Formula x1105 = x1114.forSome(x1106);
		Formula x1076 = x1077.or(x1105);
		Formula x1054 = x1055.and(x1076);
		Variable x1128 = Variable.unary("DWNodeCheck_k");
		Variable x1131 = Variable.unary("DWNodeCheck_i");
		Decls x1130 = x1131.oneOf(x6);
		Expression x1136 = x12.transpose();
		Expression x1135 = x1136.closure();
		Expression x1134 = x735.join(x1135);
		Formula x1133 = x1131.in(x1134);
		Formula x1138 = x1131.eq(x750);
		Formula x1137 = x1138.not();
		Formula x1132 = x1133.and(x1137);
		Expression x1129 = x1132.comprehension(x1130);
		Decls x1127 = x1128.oneOf(x1129);
		Expression x1145 = x714.join(x10);
		Expression x1144 = x1128.join(x1145);
		Expression x1143 = x9.join(x1144);
		Formula x1142 = x1143.no();
		Variable x1148 = Variable.unary("isLeg_pref2");
		Expression x1149 = x1143.join(x814);
		Decls x1147 = x1148.oneOf(x1149);
		Expression x1156 = x714.join(x10);
		Expression x1155 = x1156.join(x6);
		Expression x1154 = x1155.join(x6);
		Formula x1153 = x1128.in(x1154);
		Formula x1152 = x1153.not();
		Formula x1151 = x1152.not();
		Expression x1160 = x714.join(x10);
		Expression x1159 = x1128.join(x1160);
		Expression x1158 = x12.join(x1159);
		Expression x1162 = x1143.join(x10);
		Expression x1161 = x1148.join(x1162);
		Formula x1157 = x1158.eq(x1161);
		Formula x1150 = x1151.and(x1157);
		Formula x1146 = x1150.forSome(x1147);
		Formula x1141 = x1142.or(x1146);
		Formula x1140 = x1141.not();
		Variable x1165 = Variable.unary("DWNodeCheck_first_hop_k_pref");
		Expression x1169 = x714.join(x10);
		Expression x1168 = x1128.join(x1169);
		Expression x1167 = x9.join(x1168);
		Expression x1166 = x1167.join(x861);
		Decls x1164 = x1165.oneOf(x1166);
		Expression x1178 = x714.join(x10);
		Expression x1177 = x1178.join(x6);
		Expression x1176 = x1177.join(x6);
		Formula x1175 = x1128.in(x1176);
		Formula x1174 = x1175.not();
		Formula x1173 = x1174.not();
		Expression x1182 = x714.join(x10);
		Expression x1181 = x1128.join(x1182);
		Expression x1180 = x12.join(x1181);
		Expression x1184 = x1167.join(x10);
		Expression x1183 = x1165.join(x1184);
		Formula x1179 = x1180.eq(x1183);
		Formula x1172 = x1173.and(x1179);
		Formula x1171 = x1172.not();
		Expression x1188 = x1167.join(x922);
		Expression x1187 = x1165.join(x1188);
		Expression x1190 = x714.join(x922);
		Expression x1189 = x750.join(x1190);
		Formula x1186 = x1187.eq(x1189);
		Expression x1193 = x12.closure();
		Expression x1192 = x750.join(x1193);
		Formula x1191 = x1128.in(x1192);
		Formula x1185 = x1186.and(x1191);
		Formula x1170 = x1171.or(x1185);
		Formula x1163 = x1170.forAll(x1164);
		Formula x1139 = x1140.and(x1163);
		Formula x1126 = x1139.forAll(x1127);
		Formula x1053 = x1054.and(x1126);
		Formula x811 = x812.and(x1053);
		Formula x804 = x811.forSome(x805);
		Formula x798 = x804.forSome(x799);
		Formula x783 = x798.forSome(x784);
		Formula x773 = x783.forSome(x774);
		Formula x758 = x773.forSome(x759);
		Formula x748 = x758.forSome(x749);
		Formula x733 = x748.forSome(x734);
		Formula x725 = x733.forSome(x726);
		Formula x718 = x725.forSome(x719);
		Formula x712 = x718.forSome(x713);
		Formula x268 = x269.or(x712);
		Formula x267 = x268.not();
		Formula x144 = x145.iff(x267);
		Formula x137 = x138.or(x144);
		Formula x136 = x137.not();
		Formula x1194 = x0.eq(x0);
		Formula x1195 = x1.eq(x1);
		Formula x1196 = x2.eq(x2);
		Formula x1197 = x3.eq(x3);
		Formula x1198 = x4.eq(x4);
		Formula x1199 = x5.eq(x5);
		Formula x1200 = x6.eq(x6);
		Formula x1201 = x7.eq(x7);
		Formula x1202 = x8.eq(x8);
		Formula x1203 = x9.eq(x9);
		Formula x1204 = x10.eq(x10);
		Formula x1205 = x11.eq(x11);
		Formula x1206 = x12.eq(x12);
		Formula x1207 = x13.eq(x13);

		Formula[] fs = new Formula[] {
				x15, x16, x17, x18, x19, x26, x31, x34, x38, x39, x40, x42, x48, x57, x69, x82, x87, x109, x130, x136,
				x1194, x1195, x1196, x1197, x1198, x1199, x1200, x1201, x1202, x1203, x1204, x1205, x1206, x1207
		};
		String[] fsn = new String[] {
				"x15", "x16", "x17", "x18", "x19", "x26", "x31", "x34", "x38", "x39", "x40", "x42", "x48", "x57", "x69",
				"x82", "x87", "x109", "x130", "x136", "x1194", "x1195", "x1196", "x1197", "x1198", "x1199", "x1200",
				"x1201", "x1202", "x1203", "x1204", "x1205", "x1206", "x1207"
		};

		Formula x14 = Formula.compose(FormulaOperator.AND, fs);

		Solver solver = new Solver();
		solver.options().setSolver(SATFactory.MiniSat);
		solver.options().setBitwidth(4);
		// solver.options().setFlatten(false);
		solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
		solver.options().setSymmetryBreaking(20);
		solver.options().setSkolemDepth(0);
		solver.options().setReporter(new ConsoleReporter());
		System.out.println("Solving...");
		System.out.flush();
		Solution sol = solver.solve(x14, bounds);
		System.out.println(sol.toString());

		if (sol.instance() != null) {
			System.out.println("Evaluating...");
			Evaluator ev = new Evaluator(sol.instance(), solver.options());
			for (int i = 0; i < fs.length; i++) {
				System.out.println(fsn[i] + " =\n" + PrettyPrinter.print(fs[i], 2));
			}
			System.out.println("\n===========================\n");
			for (int i = 0; i < fs.length; i++) {
				System.out.println(fsn[i] + " = " + ev.evaluate(fs[i]));
			}
			final boolean val = ev.evaluate(x14);
			System.out.println("x14 = " + val);
			throw new AssertionError("bad instance");
		}

	}
}
