import Link from "next/link";
import DepthIcon from "@/assets/icon/depthIcon";

const etcItems = [
  {
    name: "서비스 이용약관",
    link: "#",
    hasNextPage: true,
  },
  {
    name: "개인정보처리방침",
    link: "#",
    hasNextPage: true,
  },
  {
    name: "로그아웃",
    link: "/",
    hasNextPage: false,
  },
  {
    name: "회원탈퇴",
    link: "/",
    hasNextPage: true,
  },
];

export default function ProfileMenus() {
  return (
    <div className="mb-4">
      <h2 className="font-lg mb-2 font-semibold">기타</h2>
      <div className="w-full rounded-lg bg-white shadow-[1px_1px_15px_0px_rgba(0,0,0,0.03)]">
        {etcItems.map((item) => {
          return (
            <Link
              href={item.link}
              className="flex items-center border border-b border-solid border-[#F4F3F8] px-6 py-5"
            >
              <div className="mr-3 h-6 w-6 rounded-sm bg-gray02"></div>
              <p className="w-[80%]">{item.name}</p>
              {item.hasNextPage && <DepthIcon />}
            </Link>
          );
        })}
        <div className="flex items-center px-6 py-5">
          <div className="mr-3 h-6 w-6 rounded-sm bg-gray02"></div>
          <p className="w-[75%]">버전 정보</p>
          <p>1.0.0</p>
        </div>
      </div>
    </div>
  );
}
