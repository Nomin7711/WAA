import axios from 'axios'

export const BASEURL = axios.create({
    baseURL: 'http://localhost:8080/'
})
