<template>
    <div>
        <div v-if='searchListData.length>0'>
            <Item v-for='(curdata,index) in searchListData' :key='index' :curdata='curdata'/>
        </div>
        <div v-else>数据正在加载中....</div>

        <LoadMore @getMoreData='getMoreData'/>
    </div>
</template>
<script>
    import Item from './Item/Item'
    import LoadMore from '../../../components/LoadMore/LoadMore'

    export default {
        name: 'SearchList',
        data() {
            return {
                searchListData: [],
                hasMore: false,
                page: 1
            }
        },
        components: {
            Item,
            LoadMore
        },
        props: ['kw', 'curcity'],

        methods: {
            getMoreData() {
                this.page = this.page += 1
                this.http(this.kw, this.curcity)
                    .then(data => {
                        console.log(data);
                        this.searchListData = this.searchListData.concat(data.data.data.records)
                        this.hasMore = data.data.hasMore
                    })
            },
            http(keyword, city) {
                return this.$api.getSearch({city: city, content: keyword, page: this.page})
            }
        },
        watch: {
            'kw': function (n, o) {
                if (n === o) {
                    return;
                }
                // console.log(n,o)
                this.http(this.kw, this.curcity)
                    .then(data => {
                        console.log(666666)
                        console.log(data.data.data);
                        if (data.data.data.records.length > 0) {
                            this.searchListData = data.data.data.records
                            this.hasMore = true;
                        }
                    })
            }
        },
    }
</script>
