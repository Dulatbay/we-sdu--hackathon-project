// Need to use the React-specific entry point to import createApi
import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

// Define a service using a base URL and expected endpoints
export const weSduApiPlaces = createApi({
    reducerPath: 'weSduApiPlaces',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://172.20.10.2:8585' }),
    endpoints: builder => ({
        getAllPlaces: builder.query({
            query: () => `products/places/all`,
        }),
        getProductDetailById: builder.query({
            query: (id) => `/products/products/get-detail-by-id/${id}`
        })
    }),
})

// Export hooks for usage in functional components, which are
// auto-generated based on the defined endpoints
export const { useGetAllPlacesQuery , useGetProductDetailByIdQuery} = weSduApiPlaces