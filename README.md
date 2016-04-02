###打包方法

Intellij IDEA中，Build->Build Artifact，选择`androidweekly:jar`。jar包输出在`\out\artifacts\androidweekly_jar`下面。

###使用方法

```
java -Dfile.encoding=UTF-8 -jar androidweekly.jar <html template path> <markdown template path> <json file path>
```
不加encoding的话中文会乱码。。

最后会生成填充好的markdown和html文件。

提供了两个模板`template.html`和`template.md`，`weekly.json`是需要填充进模板中的数据。

PS: 生成出来的html还是不能用的，还需要CSS inline一下，比如使用[premailer](premailer.io)。然后是[litmus](https://litmus.com/)，在线预览邮件中html显示效果。