<template>
    <input type="text" class='search-input' v-model="msg" @keyup="search($event)">
</template>
<script>
    import Vue from 'vue'

    export default {
        name: 'SearchInput',
        inject: ['reload'],
        data() {
            return {
                msg: ''
            }
        },
        props: ['pk'],
        methods: {
            search(e) {
                if (e.keyCode === 13) {
                    // 判断有没有登录
                    if (Vue.cookie.get('token')) {
                        this.$router.push('/search/' + this.msg)
                        if (this.msg == this.pk) {
                            return
                        }
                        this.$emit('setSearchMsgAciton', {data: this.msg})
                    } else {
                        // console.log('还未登录')
                        this.$router.push('/login')
                    }
                }

            }
        },
        mounted() {
            this.msg = this.pk
            this.$emit('setSearchMsgAciton', {data: this.pk})
        },
        watch: {
            'pk': function (n, o) {
                if (n !== this.msg) {
                    this.msg = n;
                    this.$emit('setSearchMsgAciton', {data: n})
                }
            }
        },
    }
</script>
<style lang="less" scoped>
    .search-input {
        font-size: 14px !important;
        font-weight: normal;
        border: 0;
        width: 80%;
        color: #333 !important;
        padding-left: 5px;
    }
</style>
