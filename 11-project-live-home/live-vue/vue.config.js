module.exports = {

    devServer: {
        port:8081,
        proxy: { // 前台处理跨域的
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''             // 会将 http://localhost8081/api/getBanner 替换成 http://ip:port/getBanner
                }
            }
        }
    }
}
