import http from 'k6/http';
import { check } from 'k6';

export const options = {
    vus: 1000,          // 10 concurrent virtual users
    duration: '30s',  // run for 30 seconds
};

export default function () {
    const response = http.get('http://localhost:8080/api/v1/restaurants');

    check(response, {
        'status is 200': (r) => r.status === 200,
    });
}