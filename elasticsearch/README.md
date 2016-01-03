## ※古いので後で治す

AmazonLinuxを使用

デフォルトでJDK1.7が入ってる。

Elasticsearch1.4を使用
java.net.UnknownHostException: ip-XXX-XXX-XXX-XXX: ip-XXX-XXX-XXX-XXX

/etc/hostsで

`127.0.0.1   localhost localhost.localdomain ip-XXX-XXX-XXX-XXX`
とかにする。

### elasticsearch.yml