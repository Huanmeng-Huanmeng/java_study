// XML处理：https://www.w3cschool.cn/groovy/groovy_xml.html
// 1.XML解析
// Groovy XmlParser类使用一个简单的模型来将XML文档解析为Node实例的树。
// 每个节点都有XML元素的名称，元素的属性和对任何子节点的引用。这个模型足够用于大多数简单的XML处理。

// 2.XML标记生成器
// MarkupBuilder用于构造整个XML文档。通过首先创建XML文档类的对象来创建XML文档。
// 一旦创建了对象，可以调用伪方法来创建XML文档的各种元素。
class OperatorXml {
    public static void main(String[] args) {
        String xmlFileName = "doc" + File.separator + "xml" + File.separator + "books.xml";
        def parser = new XmlParser() // 创建xml解析对象
        def bookstore = parser.parse(xmlFileName) // 解析xml文件,返回根节点
        def attribute = bookstore.attribute("count") // 获取根节点下的属性count
        def attributes = bookstore.attributes() // 获取根节点下所有属性，返回一个map
        print(attributes.get("name"))
        bookstore.book.each{
            book ->
                print("book下的属性name:")
                println "${book["@id"]}"

                print("book下的第一个name节点下的值")
                println("${book.name[0].text()}")

                print("book下的第二个name节点下的值")
                println("${book.name[1].text()}")
        }
        print attribute
    }
}