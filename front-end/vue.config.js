module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                //https: true,
                changeOrigin: true,
                ws: true,
                /*pathRewrite: {
                    '^/api': ''
                }*/
            }
        }
    }
};