package typo.anormruntime

import scala.collection.IterableFactory

final case class RowParser[Row](rows: Array[PgType[?]], decode: Array[?] => Row) {
  val colsWithIndex: Array[(PgType[?], Int)] =
    rows.zipWithIndex
  def single: ResultSetParser[Either[String, Row]] =
    new ResultSetParser.ExactlyOne(this)
  def toList : ResultSetParser[List[Row]] =
    new ResultSetParser.Many(this, List)
  def toLazyList : ResultSetParser[LazyList[Row]] =
    new ResultSetParser.Many(this, LazyList)
  def to[I[r] <: Iterable[r]](factory: IterableFactory[I]) : ResultSetParser[I[Row]] =
    new ResultSetParser.Many(this, factory)
  def ? : ResultSetParser[Option[Row]] =
    new ResultSetParser.MaybeOne(this)
}

object RowParser{
  // format: off
  def for1[A1, Row](a: PgType[A1])(decode: A1 => Row): RowParser[Row] = 
    RowParser(Array(a), (l: Array[?]) => decode(l(0).asInstanceOf[A1]))
  def for2[A1, A2, Row](a1: PgType[A1], a2: PgType[A2])(decode: (A1, A2) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2]))
  def for3[A1, A2, A3, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3])(decode: (A1, A2, A3) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3]))
  def for4[A1, A2, A3, A4, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4])(decode: (A1, A2, A3, A4) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4]))
  def for5[A1, A2, A3, A4, A5, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5])(decode: (A1, A2, A3, A4, A5) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5]))
  def for6[A1, A2, A3, A4, A5, A6, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6])(decode: (A1, A2, A3, A4, A5, A6) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6]))
  def for7[A1, A2, A3, A4, A5, A6, A7, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7])(decode: (A1, A2, A3, A4, A5, A6, A7) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7]))
  def for8[A1, A2, A3, A4, A5, A6, A7, A8, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8])(decode: (A1, A2, A3, A4, A5, A6, A7, A8) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8]))
  def for9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9]))
  def for10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10]))
  def for11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11]))
  def for12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12]))
  def for13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13]))
  def for14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14]))
  def for15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15]))
  def for16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Row): RowParser[Row] = 
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16]))
  def for17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16], a17: PgType[A17])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Row): RowParser[Row] =
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16], l(16).asInstanceOf[A17]))
  def for18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16], a17: PgType[A17], a18: PgType[A18])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Row): RowParser[Row] =
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16], l(16).asInstanceOf[A17], l(17).asInstanceOf[A18]))
  def for19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16], a17: PgType[A17], a18: PgType[A18], a19: PgType[A19])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Row): RowParser[Row] =
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16], l(16).asInstanceOf[A17], l(17).asInstanceOf[A18], l(18).asInstanceOf[A19]))
  def for20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16], a17: PgType[A17], a18: PgType[A18], a19: PgType[A19], a20: PgType[A20])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Row): RowParser[Row] =
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16], l(16).asInstanceOf[A17], l(17).asInstanceOf[A18], l(18).asInstanceOf[A19], l(19).asInstanceOf[A20]))
  def for21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16], a17: PgType[A17], a18: PgType[A18], a19: PgType[A19], a20: PgType[A20], a21: PgType[A21])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Row): RowParser[Row] =
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12], l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16], l(16).asInstanceOf[A17], l(17).asInstanceOf[A18], l(18).asInstanceOf[A19], l(19).asInstanceOf[A20], l(20).asInstanceOf[A21]))
  def for22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Row](a1: PgType[A1], a2: PgType[A2], a3: PgType[A3], a4: PgType[A4], a5: PgType[A5], a6: PgType[A6], a7: PgType[A7], a8: PgType[A8], a9: PgType[A9], a10: PgType[A10], a11: PgType[A11], a12: PgType[A12], a13: PgType[A13], a14: PgType[A14], a15: PgType[A15], a16: PgType[A16], a17: PgType[A17], a18: PgType[A18], a19: PgType[A19], a20: PgType[A20], a21: PgType[A21], a22: PgType[A22])(decode: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Row): RowParser[Row] =
    RowParser(Array(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22), (l: Array[?]) => decode(l(0).asInstanceOf[A1], l(1).asInstanceOf[A2], l(2).asInstanceOf[A3], l(3).asInstanceOf[A4], l(4).asInstanceOf[A5], l(5).asInstanceOf[A6], l(6).asInstanceOf[A7], l(7).asInstanceOf[A8], l(8).asInstanceOf[A9], l(9).asInstanceOf[A10], l(10).asInstanceOf[A11], l(11).asInstanceOf[A12],l(12).asInstanceOf[A13], l(13).asInstanceOf[A14], l(14).asInstanceOf[A15], l(15).asInstanceOf[A16], l(16).asInstanceOf[A17], l(17).asInstanceOf[A18], l(18).asInstanceOf[A19], l(19).asInstanceOf[A20], l(20).asInstanceOf[A21], l(21).asInstanceOf[A22]))
  // format: on

  def forMany[Row](array: Array[PgType[?]], decode: Array[?] => Row): RowParser[Row] =
    RowParser(array, decode)
}