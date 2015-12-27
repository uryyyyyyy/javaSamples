namespace java jp.co.aainc.thrift // Namespaceの定義
 
 // Listの定義
typedef list<map<string, bool>> ListMap1
 
// Enumの定義
enum Enum1
{
    YES,
    NO
}
 
// 構造の定義
struct StructTest {
    1: required bool boolTest;
    2: required byte byteTest;
    3: required i16 i16Test; // Javaではshort
    4: optional i32 i32Test; // Javaではint
    5: optional i64 i64Test; // Javaではlong
    6: required double doubleTest; 
    7: required string stringTest;
    8: optional ListMap1 listMapTest; // 上で定義したList
    9: optional Enum1 enumTest; // 上で定義したEnum
}
 
struct ResultTest {
    1: bool result;
}
 
// サービスを定義
service ServiceTest
{
    ResultTest executeTest1(1:StructTest parameter) // 引数はStructTestで結果はResultTestで返す
}
