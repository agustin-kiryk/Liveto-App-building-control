import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from "@reduxjs/toolkit";
// Cambiamos mySlice por el nombre de nuestro slice (usersSlice, toDosSlice...)
export interface counterState {
  count: number;
}

const initialState: counterState = {
  count: 0,
};

export const counterSlice = createSlice({
  name: "counter",
  initialState,
  reducers: {
    increment: (state, action: PayloadAction<number>) => {
      state.count += action.payload;
    },
    decrement: (state, action: PayloadAction<number>) => {
      state.count -= action.payload;
    },
  },
});

export const { increment, decrement } = counterSlice.actions;

export default counterSlice.reducer;
